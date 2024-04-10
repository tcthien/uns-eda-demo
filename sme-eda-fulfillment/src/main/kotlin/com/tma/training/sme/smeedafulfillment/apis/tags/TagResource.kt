package com.tma.training.sme.smeedafulfillment.apis.tags

import com.tma.training.sme.smeedafulfillment.apis.tags.dtos.SimpleTagDto
import com.tma.training.sme.smeedafulfillment.apis.tags.dtos.TagDto
import com.tma.training.sme.smeedafulfillment.businesses.boundaries.tags.SearchTag
import org.slf4j.LoggerFactory
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/tags", produces = [MediaType.APPLICATION_JSON_VALUE])
class TagResource(
    private val searchTag: SearchTag,
) {
    companion object {
        private val log = LoggerFactory.getLogger(TagResource::class.java)
    }

    @GetMapping("/{tagId}")
    fun getTag(
        @PathVariable tagId: String
    ): TagDto = searchTag.execute(SearchTag.IdRequest(tagId)).tag

    @GetMapping("")
    fun getTags(
    ): List<SimpleTagDto> = searchTag.execute(SearchTag.Request()).tags
}
