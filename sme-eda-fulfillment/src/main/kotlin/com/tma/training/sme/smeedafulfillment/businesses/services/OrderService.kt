package com.tma.training.sme.smeedafulfillment.businesses.services

import com.tma.training.sme.smeedafulfillment.databases.entities.Order

interface OrderService {
    fun save(order: Order): Order
    fun findAll(): List<Order>
    fun findById(orderId: String): Order
}