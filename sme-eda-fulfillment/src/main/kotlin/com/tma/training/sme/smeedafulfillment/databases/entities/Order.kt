package com.tma.training.sme.smeedafulfillment.databases.entities

import com.tma.training.sme.smeedaecom.apis.customers.dtos.CustomerDetailDto
import com.tma.training.sme.smeedafulfillment.apis.orders.dtos.OrderItemDto
import com.tma.training.sme.smeedafulfillment.commons.dtos.Address
import org.springframework.data.mongodb.core.mapping.Document
import javax.validation.constraints.NotBlank

@Document(collection = "fulfillment_orders")
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
