package com.tma.training.sme.smeedafulfillment.businesses.boundaries.tags

import com.tma.training.sme.smeedafulfillment.apis.products.dtos.ProductCreatedEvt
import com.tma.training.sme.smeedafulfillment.apis.tags.dtos.TagDto

interface CreateTagFromEvent {
    fun execute(request: ProductCreatedEvt): TagDto
}