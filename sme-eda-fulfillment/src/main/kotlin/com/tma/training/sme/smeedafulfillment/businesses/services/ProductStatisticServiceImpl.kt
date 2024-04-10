package com.tma.training.sme.smeedafulfillment.businesses.services

import com.tma.training.sme.smeedafulfillment.databases.entities.ProductStatistic
import com.tma.training.sme.smeedafulfillment.databases.repositories.ProductStatisticRepository
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Update
import org.springframework.stereotype.Service

@Service
class ProductStatisticServiceImpl(
    private val productStatisticRepository: ProductStatisticRepository,
    private val mongoOperations: MongoOperations,
) : ProductStatisticService {
    override fun save(productStatistic: ProductStatistic): ProductStatistic = productStatisticRepository.save(productStatistic)
    override fun findAll(): List<ProductStatistic> = productStatisticRepository.findAllByIdIsNotNullOrderByIdDesc()
    override fun find(): ProductStatistic = productStatisticRepository.findById("PRODUCT_STATISTIC").orElse(ProductStatistic(id = "PRODUCT_STATISTIC"))
    override fun delete() = productStatisticRepository.deleteById("PRODUCT_STATISTIC")
    override fun updateStatistic(count: Long) {
        val query = Query(Criteria.where(ProductStatistic::id.name).`is`("PRODUCT_STATISTIC"))
        val update = Update()
        update.inc(ProductStatistic::totalProduct.name, count)
        mongoOperations.upsert(query, update, ProductStatistic::class.java)
    }
}