package com.tma.training.sme.smeedafulfillment.businesses.boundaries.productstatistic

import com.tma.training.sme.smeedafulfillment.apis.productstatistic.dtos.ProductStatisticDto

interface SearchProductStatistic {
    fun execute(): Response

    data class Response(
        val productStatisticDto: ProductStatisticDto
    )
}