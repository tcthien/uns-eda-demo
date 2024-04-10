package com.tma.training.sme.smeedafulfillment.businesses.boundaries.orders

import com.tma.training.sme.smeedafulfillment.apis.orders.dtos.OrderDto
import com.tma.training.sme.smeedafulfillment.apis.orders.dtos.SimpleOrderDto

interface SearchOrder {
    fun execute(request: Request): Response
    fun execute(request: IdRequest): OrderDetailResponse

    class Request()
    data class Response(
        val orders: List<SimpleOrderDto>
    )

    data class IdRequest(
        val orderId: String
    )
    data class OrderDetailResponse(
        val order: OrderDto
    )
}