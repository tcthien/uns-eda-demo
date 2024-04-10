package com.tma.training.sme.smeedafulfillment.businesses.services

import com.tma.training.sme.smeedafulfillment.databases.entities.ProductStatistic

interface ProductStatisticService {
    fun save(productStatistic: ProductStatistic): ProductStatistic
    fun findAll(): List<ProductStatistic>
    fun find(): ProductStatistic
    fun delete()
    fun updateStatistic(count: Long)
}