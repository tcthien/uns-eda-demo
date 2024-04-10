package com.tma.training.sme.smeedaecom.apis.orders.dtos

import com.tma.training.sme.smeedaecom.apis.customers.dtos.CustomerDetailDto
import com.tma.training.sme.smeedaecom.commons.dtos.Address
import com.tma.training.sme.smeedaecom.databases.entities.OrderStatus
import javax.validation.constraints.NotBlank

data class OrderDto(
    var id: String? = null,

    var orderExternalRef: String = "",

    @NotBlank
    var customerInfo: CustomerDetailDto = CustomerDetailDto(),
    @NotBlank
    var customerShippingAddress: Address = Address(),
    var customerBillingAddress: Address? = null,

    var orderItems: MutableList<OrderItemDto> = mutableListOf(),
    var trackingCode: String = "",

    var status: OrderStatus = OrderStatus.NONE
)
