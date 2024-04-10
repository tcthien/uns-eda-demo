package com.tma.training.sme.smeedafulfillment.businesses.boundaries.productstatistic

import com.tma.training.sme.smeedafulfillment.apis.productstatistic.dtos.ProductStatisticDto

interface RecordProductStatistic {
    fun execute(request: Request): Response

    data class Request(
        val count: Long
    )
    data class Response(
        val productStatisticDto: ProductStatisticDto
    )
}