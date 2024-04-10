package com.tma.training.sme.smeedaecom.restclient

import com.tma.training.sme.smeedaecom.restclient.dtos.ProductDto
import com.tma.training.sme.smeedafulfillment.rabbitmq.RabbitMQConsumerConfig
import org.slf4j.LoggerFactory
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory
import org.springframework.stereotype.Component


@Component
class ProductRestExtension(
    private val productRestClient: ProductRestClient,
    private val circuitBreakerFactory: CircuitBreakerFactory<*, *>
) {
    companion object {
        private val LOGGER = LoggerFactory.getLogger(RabbitMQConsumerConfig::class.java)
    }

    fun findById(id: String): ProductDto =
        circuitBreakerFactory.create("findById").run({ productRestClient.findById(id) }, {
            LOGGER.error("Failed to invoke findById($id)", it)
            ProductDto()
        })

}