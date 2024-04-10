package com.tma.training.sme.smeedafulfillment.businesses.interactors

import com.tma.training.sme.smeedafulfillment.businesses.boundaries.tags.CreateTag
import com.tma.training.sme.smeedafulfillment.businesses.boundaries.tags.DeleteTag
import com.tma.training.sme.smeedafulfillment.businesses.boundaries.tags.SearchTag
import com.tma.training.sme.smeedafulfillment.businesses.services.TagMapper
import com.tma.training.sme.smeedafulfillment.businesses.services.TagService
import com.tma.training.sme.smeedafulfillment.businesses.services.formatIdWithProductId
import org.springframework.stereotype.Component

@Component
class GeneralTagInteractor(
    private val tagMapper: TagMapper,
    private val tagService: TagService,
) : CreateTag, SearchTag, DeleteTag{

    override fun execute(request: CreateTag.Request): CreateTag.Response {
        val tag = tagService.save(tagMapper.tagCreationDtoToTag(request.creationDto))
        return CreateTag.Response(tagMapper.tagToTagDto(tag))
    }

    override fun execute(request: DeleteTag.Request) {
        tagService.deleteById(formatIdWithProductId(request.tagId))
    }
    
    override fun execute(request: SearchTag.IdRequest): SearchTag.TagDetailResponse {
        val tag = tagService.findById(formatIdWithProductId(request.tagId))
        return SearchTag.TagDetailResponse(tagMapper.tagToTagDto(tag))
    }

    override fun execute(request: SearchTag.Request): SearchTag.Response {
        val tags = tagService.findAll()
        return SearchTag.Response(tags.map(tagMapper::tagToSimpleTagDto))
    }
}