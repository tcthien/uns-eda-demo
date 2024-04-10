package com.tma.training.sme.smeedafulfillment.databases.entities

import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "fulfillment_tags")
data class Tag(
    @org.springframework.data.annotation.Id
    var id: String? = null,
    var name: String = "",
    var description: String = "",
)