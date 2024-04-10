package com.tma.training.sme.smeedafulfillment.businesses.interactors

import com.tma.training.sme.smeedafulfillment.businesses.boundaries.productstatistic.RecordProductStatistic
import com.tma.training.sme.smeedafulfillment.businesses.services.ProductStatisticMapper
import com.tma.training.sme.smeedafulfillment.businesses.services.ProductStatisticService
import org.springframework.stereotype.Component

@Component
class RecordProductStatisticInteractor(
    private val productStatisticService: ProductStatisticService,
    private val productStatisticMapper: ProductStatisticMapper,
): RecordProductStatistic {

    override fun execute(request: RecordProductStatistic.Request): RecordProductStatistic.Response {
        productStatisticService.updateStatistic(request.count)
        val productStatistic = productStatisticService.find()
        return RecordProductStatistic.Response(productStatisticMapper.productStatisticToSimpleProductStatisticDto(productStatistic))
    }
}