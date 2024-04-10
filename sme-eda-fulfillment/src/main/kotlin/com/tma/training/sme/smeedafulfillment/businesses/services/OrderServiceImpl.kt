package com.tma.training.sme.smeedafulfillment.businesses.services

import com.tma.training.sme.smeedafulfillment.databases.entities.Order
import com.tma.training.sme.smeedafulfillment.databases.repositories.OrderRepository
import org.springframework.stereotype.Service

@Service
class OrderServiceImpl(
    private val orderRepository: OrderRepository
) : OrderService {
    override fun save(order: Order): Order = orderRepository.save(order)
    override fun findAll(): List<Order> = orderRepository.findAllByIdIsNotNullOrderByIdDesc()
    override fun findById(orderId: String): Order = orderRepository.findById(orderId).orElseThrow { IllegalArgumentException("Order($orderId) cannot be found") }
}