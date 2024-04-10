package com.tma.training.sme.smeedaecom.businesses.boundaries.orders

import com.tma.training.sme.smeedaecom.apis.orders.dtos.OrderCreationDto
import com.tma.training.sme.smeedaecom.apis.orders.dtos.OrderDto

interface CreateOrder {
    fun execute(request: Request): Response

    data class Request(
        val creationDto: OrderCreationDto
    )
    data class Response(
        val orderDto: OrderDto
    )
}