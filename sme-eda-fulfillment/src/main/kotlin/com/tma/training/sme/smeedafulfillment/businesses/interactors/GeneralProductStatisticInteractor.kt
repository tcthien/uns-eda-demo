package com.tma.training.sme.smeedafulfillment.businesses.interactors

import com.tma.training.sme.smeedafulfillment.businesses.boundaries.productstatistic.SearchProductStatistic
import com.tma.training.sme.smeedafulfillment.businesses.services.ProductStatisticMapper
import com.tma.training.sme.smeedafulfillment.businesses.services.ProductStatisticService
import org.springframework.stereotype.Component

@Component
class GeneralProductStatisticInteractor(
    private val productStatisticMapper: ProductStatisticMapper,
    private val productStatisticService: ProductStatisticService,
) : SearchProductStatistic {
    
    override fun execute(): SearchProductStatistic.Response {
        val productStatistic = productStatisticService.find()
        return SearchProductStatistic.Response(productStatisticMapper.productStatisticToSimpleProductStatisticDto(productStatistic))
    }
}