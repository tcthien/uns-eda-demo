package com.tma.training.sme.smeedafulfillment.apis.orders

import com.tma.training.sme.smeedafulfillment.apis.orders.dtos.OrderDto
import com.tma.training.sme.smeedafulfillment.apis.orders.dtos.SimpleOrderDto
import com.tma.training.sme.smeedafulfillment.businesses.boundaries.orders.SearchOrder
import org.slf4j.LoggerFactory
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/orders", produces = [MediaType.APPLICATION_JSON_VALUE])
class OrderResource(
    private val searchOrder: SearchOrder,
) {
    companion object {
        private val log = LoggerFactory.getLogger(OrderResource::class.java)
    }

    @GetMapping("/{orderId}")
    fun getOrder(
        @PathVariable orderId: String
    ): OrderDto = searchOrder.execute(SearchOrder.IdRequest(orderId)).order

    @GetMapping("")
    fun getOrders(
    ): List<SimpleOrderDto> = searchOrder.execute(SearchOrder.Request()).orders
}
