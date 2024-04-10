package com.tma.training.sme.smeedafulfillment.businesses.interactors

import com.tma.training.sme.smeedafulfillment.apis.orders.dtos.OrderCreatedEvt
import com.tma.training.sme.smeedafulfillment.apis.orders.dtos.OrderDto
import com.tma.training.sme.smeedafulfillment.businesses.boundaries.orders.CreateOrderFromEvent
import com.tma.training.sme.smeedafulfillment.businesses.services.OrderMapper
import com.tma.training.sme.smeedafulfillment.businesses.services.OrderService
import org.springframework.stereotype.Component

@Component
class CreateOrderFromEventInteractor(
    private val orderService: OrderService,
    private val orderMapper: OrderMapper,
) : CreateOrderFromEvent {
    override fun execute(request: OrderCreatedEvt): OrderDto {
        val order = orderService.save(
            orderMapper.orderCreatedEvtToOrder(request)
        )
        return orderMapper.orderToOrderDto(order)
    }
}