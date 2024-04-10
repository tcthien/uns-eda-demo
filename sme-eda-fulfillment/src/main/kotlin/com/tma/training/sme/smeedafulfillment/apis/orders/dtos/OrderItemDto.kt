package com.tma.training.sme.smeedafulfillment.apis.orders.dtos

import java.math.BigDecimal

data class OrderItemDto(
    var name: String = "",
    var quantity: Int = 0,
    var unitPrice: BigDecimal = BigDecimal.ZERO,
)
