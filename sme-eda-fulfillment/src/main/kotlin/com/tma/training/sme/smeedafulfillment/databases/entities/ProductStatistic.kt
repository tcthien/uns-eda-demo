package com.tma.training.sme.smeedafulfillment.databases.entities

import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "fulfillment_statistic")
data class ProductStatistic(
    @org.springframework.data.annotation.Id
    var id: String? = null,
    var totalProduct: Long = 0,
)