package com.tma.training.sme.smeedafulfillment.businesses.interactors

import com.tma.training.sme.smeedaecom.restclient.ProductRestExtension
import com.tma.training.sme.smeedafulfillment.apis.products.dtos.ProductCreatedEvt
import com.tma.training.sme.smeedafulfillment.apis.tags.dtos.TagCreationDto
import com.tma.training.sme.smeedafulfillment.apis.tags.dtos.TagDto
import com.tma.training.sme.smeedafulfillment.businesses.boundaries.tags.CreateTag
import com.tma.training.sme.smeedafulfillment.businesses.boundaries.tags.CreateTagFromEvent
import com.tma.training.sme.smeedafulfillment.businesses.services.formatIdWithProductId
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class CreateTagFromEventInteractor(
    private val createTag: CreateTag,
    private val productRestExtension: ProductRestExtension,
) : CreateTagFromEvent{

    companion object {
        private val LOGGER = LoggerFactory.getLogger(CreateTagFromEventInteractor::class.java)
    }

    override fun execute(request: ProductCreatedEvt): TagDto {
        val productDetail = productRestExtension.findById(request.id ?: throw IllegalArgumentException("productId must not be null"))
        val tagDto = createTag.execute(
            CreateTag.Request(TagCreationDto(id = formatIdWithProductId(request.id!!), name = request.name, description = productDetail.description))
        ).tagDto
        LOGGER.debug("Tag(${tagDto.id}, ${tagDto.name}) has been created")
        return tagDto
    }
}