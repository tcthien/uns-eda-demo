package com.tma.training.sme.smeedafulfillment.businesses.interactors

import com.tma.training.sme.smeedafulfillment.businesses.boundaries.orders.SearchOrder
import com.tma.training.sme.smeedafulfillment.businesses.services.OrderMapper
import com.tma.training.sme.smeedafulfillment.businesses.services.OrderService
import org.springframework.stereotype.Component

@Component
class GeneralOrderInteractor(
    private val orderMapper: OrderMapper,
    private val orderService: OrderService,
) : SearchOrder{
    
    override fun execute(request: SearchOrder.IdRequest): SearchOrder.OrderDetailResponse {
        val order = orderService.findById(request.orderId)
        return SearchOrder.OrderDetailResponse(orderMapper.orderToOrderDto(order))
    }

    override fun execute(request: SearchOrder.Request): SearchOrder.Response {
        val orders = orderService.findAll()
        return SearchOrder.Response(orders.map(orderMapper::orderToSimpleOrderDto))
    }
}