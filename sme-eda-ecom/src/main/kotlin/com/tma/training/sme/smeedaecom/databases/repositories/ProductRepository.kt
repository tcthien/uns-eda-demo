package com.tma.training.sme.smeedaecom.databases.repositories

import com.tma.training.sme.smeedaecom.databases.entities.Product
import org.springframework.data.mongodb.repository.MongoRepository

interface ProductRepository : MongoRepository<Product, String> {
    fun findAllByIdIsNotNullOrderByIdDesc(): MutableList<Product>
}
