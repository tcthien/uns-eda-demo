package com.tma.training.sme.smeedaecom.apis.orders

import com.tma.training.sme.smeedaecom.apis.orders.dtos.OrderCreationDto
import com.tma.training.sme.smeedaecom.apis.orders.dtos.OrderDto
import com.tma.training.sme.smeedaecom.businesses.boundaries.orders.CreateOrder
import org.slf4j.LoggerFactory
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api/orders", produces = [MediaType.APPLICATION_JSON_VALUE])
class OrderResource(
    private val createOrder: CreateOrder,
) {
    companion object {
        private val log = LoggerFactory.getLogger(OrderResource::class.java)
    }

    @PostMapping("")
    fun createOrder(
        @Valid @RequestBody orderCreationDto: OrderCreationDto,
    ): OrderDto = createOrder.execute(CreateOrder.Request(orderCreationDto)).orderDto
}
