package com.tma.training.sme.smeedafulfillment.businesses.services

import com.tma.training.sme.smeedafulfillment.apis.tags.dtos.SimpleTagDto
import com.tma.training.sme.smeedafulfillment.apis.tags.dtos.TagCreationDto
import com.tma.training.sme.smeedafulfillment.apis.tags.dtos.TagDto
import com.tma.training.sme.smeedafulfillment.databases.entities.Tag
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface TagMapper {
    fun tagCreationDtoToTag(creationDto: TagCreationDto): Tag
    fun tagToTagDto(tag: Tag): TagDto
    fun tagToSimpleTagDto(tag: Tag): SimpleTagDto
}
