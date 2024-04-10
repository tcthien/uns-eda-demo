package com.tma.training.sme.smeedaecom.databases.repositories

import com.tma.training.sme.smeedaecom.databases.entities.Order
import org.springframework.data.mongodb.repository.MongoRepository

interface OrderRepository : MongoRepository<Order, String>
