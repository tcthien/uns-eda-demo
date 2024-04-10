package com.tma.training.sme.smeedaecom.apis.products.dtos

import java.math.BigDecimal

data class ProductCreationDto(
    var name: String = "",
    var summary: String = "",

    var description: String = "",
    var price: BigDecimal = BigDecimal.ZERO
)