package com.tma.training.sme.smeedaecom.restclient

import com.tma.training.sme.smeedaecom.restclient.dtos.ProductDto

interface ProductRestClient {
    fun findById(id: String): ProductDto
}