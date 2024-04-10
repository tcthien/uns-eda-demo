package com.tma.training.sme.smeedafulfillment.databases.repositories

import com.tma.training.sme.smeedafulfillment.databases.entities.Tag
import org.springframework.data.mongodb.repository.MongoRepository

interface TagRepository : MongoRepository<Tag, String> {
    fun findAllByIdIsNotNullOrderByIdDesc(): MutableList<Tag>
}
