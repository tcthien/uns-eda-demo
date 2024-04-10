package com.tma.training.sme.smeedafulfillment.businesses.boundaries.orders

import com.tma.training.sme.smeedafulfillment.apis.orders.dtos.OrderCreatedEvt
import com.tma.training.sme.smeedafulfillment.apis.orders.dtos.OrderDto

interface CreateOrderFromEvent {
    fun execute(request: OrderCreatedEvt): OrderDto
}