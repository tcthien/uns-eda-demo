package com.tma.training.sme.smeedaecom.databases.entities

import com.tma.training.sme.smeedaecom.apis.customers.dtos.CustomerDetailDto
import com.tma.training.sme.smeedaecom.apis.orders.dtos.OrderItemDto
import com.tma.training.sme.smeedaecom.commons.dtos.Address
import org.springframework.data.mongodb.core.mapping.Document
import javax.validation.constraints.NotBlank

@Document(collection = "ecom_orders")
data class Order(
    @org.springframework.data.annotation.Id
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
