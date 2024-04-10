package com.tma.training.sme.smeedaecom.businesses.boundaries.products

interface DeleteProduct {
    fun execute(request: Request)

    data class Request(
        val productId: String
    )
}