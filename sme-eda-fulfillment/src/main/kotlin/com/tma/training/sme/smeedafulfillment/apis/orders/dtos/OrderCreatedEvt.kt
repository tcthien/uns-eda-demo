package com.tma.training.sme.smeedafulfillment.apis.orders.dtos

import com.tma.training.sme.smeedaecom.apis.customers.dtos.CustomerDetailDto
import com.tma.training.sme.smeedafulfillment.commons.dtos.Address
import com.tma.training.sme.smeedafulfillment.databases.entities.OrderStatus
import javax.validation.constraints.NotBlank

data class OrderCreatedEvt(
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