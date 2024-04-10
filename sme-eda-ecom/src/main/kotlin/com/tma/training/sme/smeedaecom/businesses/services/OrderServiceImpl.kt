package com.tma.training.sme.smeedaecom.businesses.services

import com.tma.training.sme.smeedaecom.databases.entities.Order
import com.tma.training.sme.smeedaecom.databases.repositories.OrderRepository
import org.springframework.stereotype.Service

@Service
class OrderServiceImpl(
    private val orderRepository: OrderRepository
) : OrderService {
    override fun save(order: Order): Order = orderRepository.save(order)
}