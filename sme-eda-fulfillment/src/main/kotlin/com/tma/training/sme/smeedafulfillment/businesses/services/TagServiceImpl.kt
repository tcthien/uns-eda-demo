package com.tma.training.sme.smeedafulfillment.businesses.services

import com.tma.training.sme.smeedafulfillment.databases.entities.Tag
import com.tma.training.sme.smeedafulfillment.databases.repositories.TagRepository
import org.springframework.stereotype.Service

@Service
class TagServiceImpl(
    private val tagRepository: TagRepository
) : TagService {
    override fun save(tag: Tag): Tag = tagRepository.save(tag)
    override fun findAll(): List<Tag> = tagRepository.findAllByIdIsNotNullOrderByIdDesc()
    override fun findById(tagId: String): Tag = tagRepository.findById(tagId).orElseThrow { IllegalArgumentException("Tag($tagId) cannot be found") }
    override fun deleteById(tagId: String) = tagRepository.deleteById(tagId)
}