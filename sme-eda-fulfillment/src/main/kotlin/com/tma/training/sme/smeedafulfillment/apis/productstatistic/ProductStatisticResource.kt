package com.tma.training.sme.smeedafulfillment.apis.productstatistic

import com.tma.training.sme.smeedafulfillment.apis.productstatistic.dtos.ProductStatisticDto
import com.tma.training.sme.smeedafulfillment.businesses.boundaries.productstatistic.SearchProductStatistic
import org.slf4j.LoggerFactory
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/product-statistic", produces = [MediaType.APPLICATION_JSON_VALUE])
class ProductStatisticResource(
    private val searchProductStatistic: SearchProductStatistic,
) {
    companion object {
        private val log = LoggerFactory.getLogger(ProductStatisticResource::class.java)
    }

    @GetMapping("")
    fun getProductStatistic(
    ): ProductStatisticDto = searchProductStatistic.execute().productStatisticDto
}
