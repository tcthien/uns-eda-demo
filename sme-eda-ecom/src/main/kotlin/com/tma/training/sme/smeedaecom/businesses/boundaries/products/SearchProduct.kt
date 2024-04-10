package com.tma.training.sme.smeedaecom.businesses.boundaries.products

import com.tma.training.sme.smeedaecom.apis.products.dtos.ProductDto
import com.tma.training.sme.smeedaecom.apis.products.dtos.SimpleProductDto

interface SearchProduct {
    fun execute(request: Request): Response
    fun execute(request: IdRequest): ProductDetailResponse

    class Request()
    data class Response(
        val products: List<SimpleProductDto>
    )

    data class IdRequest(
        val productId: String
    )
    data class ProductDetailResponse(
        val product: ProductDto
    )
}