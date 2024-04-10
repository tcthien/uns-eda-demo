package com.tma.training.sme.smeedaecom.databases.entities

import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal

@Document(collection = "ecom_products")
data class Product(
    @org.springframework.data.annotation.Id
    var id: String? = null,
    var name: String = "",
    var summary: String = "",

    var description: String = "",
    var price: BigDecimal = BigDecimal.ZERO
)