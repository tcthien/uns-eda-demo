package com.tma.training.sme.smeedafulfillment.businesses.boundaries.tags

import com.tma.training.sme.smeedafulfillment.apis.tags.dtos.SimpleTagDto
import com.tma.training.sme.smeedafulfillment.apis.tags.dtos.TagDto

interface SearchTag {
    fun execute(request: Request): Response
    fun execute(request: IdRequest): TagDetailResponse

    class Request()
    data class Response(
        val tags: List<SimpleTagDto>
    )

    data class IdRequest(
        val tagId: String
    )
    data class TagDetailResponse(
        val tag: TagDto
    )
}