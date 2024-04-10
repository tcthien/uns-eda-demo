package com.tma.training.sme.smeedaecom.businesses.services

import com.tma.training.sme.smeedaecom.databases.entities.Order

interface OrderService {
    fun save(order: Order): Order
}