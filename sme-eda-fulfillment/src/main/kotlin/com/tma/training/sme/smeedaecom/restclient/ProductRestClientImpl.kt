package com.tma.training.sme.smeedaecom.restclient

import com.tma.training.sme.smeedaecom.restclient.dtos.ProductDto
import org.springframework.retry.annotation.CircuitBreaker
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class ProductRestClientImpl(
    private val ecomRestTemplate: RestTemplate
) : ProductRestClient {

    @CircuitBreaker
    override fun findById(id: String): ProductDto {
        return ecomRestTemplate.getForObject("/api/products/$id", ProductDto::class.java) ?: throw IllegalArgumentException("Product($id) not found")
    }

}