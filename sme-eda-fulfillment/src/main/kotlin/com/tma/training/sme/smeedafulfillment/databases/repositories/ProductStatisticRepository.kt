package com.tma.training.sme.smeedafulfillment.databases.repositories

import com.tma.training.sme.smeedafulfillment.databases.entities.ProductStatistic
import org.springframework.data.mongodb.repository.MongoRepository

interface ProductStatisticRepository : MongoRepository<ProductStatistic, String> {
    fun findAllByIdIsNotNullOrderByIdDesc(): MutableList<ProductStatistic>
}
