package com.tma.training.sme.smeedafulfillment.databases.repositories

import com.tma.training.sme.smeedafulfillment.databases.entities.Order
import org.springframework.data.mongodb.repository.MongoRepository

interface OrderRepository : MongoRepository<Order, String> {
    fun findAllByIdIsNotNullOrderByIdDesc(): List<Order>
}
