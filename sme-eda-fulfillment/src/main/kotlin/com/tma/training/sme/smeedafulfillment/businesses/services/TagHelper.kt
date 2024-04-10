package com.tma.training.sme.smeedafulfillment.businesses.services

import com.tma.training.sme.smeedafulfillment.databases.entities.Tag

fun formatIdWithProductId(productId: String): String = "PRODUCT-$productId"
fun Tag.formatIdFromProductId(productId: String): Tag {
    this.id = formatIdWithProductId(productId)
    return this
}