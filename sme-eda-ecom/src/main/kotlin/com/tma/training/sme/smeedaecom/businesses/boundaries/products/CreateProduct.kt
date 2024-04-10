package com.tma.training.sme.smeedaecom.businesses.boundaries.products

import com.tma.training.sme.smeedaecom.apis.products.dtos.ProductCreationDto
import com.tma.training.sme.smeedaecom.apis.products.dtos.ProductDto

interface CreateProduct {
    fun execute(request: Request): Response

    data class Request(
        val creationDto: ProductCreationDto
    )
    data class Response(
        val productDto: ProductDto
    )
}