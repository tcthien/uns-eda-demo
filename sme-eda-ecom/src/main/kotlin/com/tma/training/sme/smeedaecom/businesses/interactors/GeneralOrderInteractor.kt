package com.tma.training.sme.smeedaecom.businesses.interactors

import com.tma.training.sme.smeedaecom.businesses.boundaries.orders.CreateOrder
import com.tma.training.sme.smeedaecom.businesses.services.OrderMapper
import com.tma.training.sme.smeedaecom.businesses.services.OrderNumberGenerator
import com.tma.training.sme.smeedaecom.businesses.services.OrderService
import com.tma.training.sme.smeedaecom.databases.entities.OrderStatus
import com.tma.training.sme.smeedaecom.rabbitmq.EcomEventConstants
import com.tma.training.sme.smeedaecom.rabbitmq.RabbitMQEventBroadcaster
import org.springframework.stereotype.Component

@Component
class GeneralOrderInteractor(
    private val orderMapper: OrderMapper,
    private val orderService: OrderService,
    private val eventBroadcaster: RabbitMQEventBroadcaster,
) : CreateOrder {
    override fun execute(request: CreateOrder.Request): CreateOrder.Response {
        val order = orderService.save(
            orderMapper.orderCreationDtoToOrder(request.creationDto).apply {
                orderExternalRef = OrderNumberGenerator.generateOrderNumber()
                status = OrderStatus.PROCESSING
            }
        )
        eventBroadcaster.send(
            event = orderMapper.orderToOrderCreatedEvt(order),
            eventType = EcomEventConstants.EVENT__ORDER_CREATION,
        )
        return CreateOrder.Response(orderMapper.orderToOrderDto(order))
    }
}