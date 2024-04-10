package com.tma.training.sme.smeedafulfillment.apis.orders.dtos

import com.tma.training.sme.smeedaecom.apis.customers.dtos.CustomerDetailDto
import com.tma.training.sme.smeedafulfillment.databases.entities.OrderStatus

data class SimpleOrderDto(
    var id: String? = null,

    var orderExternalRef: String = "",
    var customerInfo: CustomerDetailDto = CustomerDetailDto(),

    var orderItems: MutableList<OrderItemDto> = mutableListOf(),
    var status: OrderStatus = OrderStatus.NONE
)
