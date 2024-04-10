package com.tma.training.sme.smeedafulfillment.businesses.services

import com.tma.training.sme.smeedafulfillment.databases.entities.Tag

interface TagService {
    fun save(tag: Tag): Tag
    fun findAll(): List<Tag>
    fun findById(tagId: String): Tag
    fun deleteById(tagId: String)
}