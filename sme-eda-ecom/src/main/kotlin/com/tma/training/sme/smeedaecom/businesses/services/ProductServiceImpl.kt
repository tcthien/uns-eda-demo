package com.tma.training.sme.smeedaecom.businesses.services

import com.tma.training.sme.smeedaecom.databases.entities.Product
import com.tma.training.sme.smeedaecom.databases.repositories.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductServiceImpl(
    private val productRepository: ProductRepository
) : ProductService {
    override fun save(product: Product): Product = productRepository.save(product)
    override fun findAll(): List<Product> = productRepository.findAllByIdIsNotNullOrderByIdDesc()
    override fun findById(productId: String): Product = productRepository.findById(productId).orElseThrow { IllegalArgumentException("Product($productId) cannot be found") }
    override fun deleteById(productId: String) = productRepository.deleteById(productId)
}