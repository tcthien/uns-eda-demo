package com.tma.training.sme.smeedafulfillment.businesses.boundaries.tags

import com.tma.training.sme.smeedafulfillment.apis.tags.dtos.TagCreationDto
import com.tma.training.sme.smeedafulfillment.apis.tags.dtos.TagDto

interface CreateTag {
    fun execute(request: Request): Response

    data class Request(
        val creationDto: TagCreationDto
    )
    data class Response(
        val tagDto: TagDto
    )
}