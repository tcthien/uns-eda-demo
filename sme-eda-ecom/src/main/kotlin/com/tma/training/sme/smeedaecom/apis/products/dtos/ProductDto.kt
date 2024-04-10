package com.tma.training.sme.smeedaecom.apis.products.dtos

import java.math.BigDecimal

data class ProductDto(
    var id: String? = null,
    var name: String = "",
    var summary: String = "",

    var description: String = "",
    var price: BigDecimal = BigDecimal.ZERO
)