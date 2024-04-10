package com.tma.training.sme.smeedaecom.apis.orders.dtos

import com.tma.training.sme.smeedaecom.apis.customers.dtos.CustomerRequestDto
import com.tma.training.sme.smeedaecom.commons.dtos.Address
import javax.validation.constraints.NotBlank

data class OrderCreationDto(
    @NotBlank
    var customerInfo: CustomerRequestDto = CustomerRequestDto(),
    @NotBlank
    var customerShippingAddress: Address = Address(),
    var customerBillingAddress: Address? = null,

    var orderItems: MutableList<OrderItemDto> = mutableListOf(),
    var trackingCode: String = "",
)