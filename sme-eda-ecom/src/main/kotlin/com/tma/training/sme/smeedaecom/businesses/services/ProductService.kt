package com.tma.training.sme.smeedaecom.businesses.services

import com.tma.training.sme.smeedaecom.databases.entities.Product

interface ProductService {
    fun save(product: Product): Product
    fun findAll(): List<Product>
    fun findById(productId: String): Product
    fun deleteById(productId: String)
}