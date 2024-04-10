package com.tma.training.sme.smeedafulfillment.businesses.boundaries.tags

interface DeleteTag {
    fun execute(request: Request)

    data class Request(
        val tagId: String
    )
}