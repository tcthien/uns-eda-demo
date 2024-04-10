package com.tma.training.sme.smeedaecom.apis.products.dtos

import java.math.BigDecimal

data class ProductCreatedEvt(
    var id: String? = null,
    var name: String = "",
    var price: BigDecimal = BigDecimal.ZERO
)