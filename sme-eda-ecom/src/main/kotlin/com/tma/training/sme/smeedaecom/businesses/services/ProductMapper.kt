package com.tma.training.sme.smeedaecom.businesses.services

import com.tma.training.sme.smeedaecom.apis.products.dtos.ProductCreatedEvt
import com.tma.training.sme.smeedaecom.apis.products.dtos.ProductCreationDto
import com.tma.training.sme.smeedaecom.apis.products.dtos.ProductDeletedEvt
import com.tma.training.sme.smeedaecom.apis.products.dtos.ProductDto
import com.tma.training.sme.smeedaecom.apis.products.dtos.SimpleProductDto
import com.tma.training.sme.smeedaecom.databases.entities.Product
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface ProductMapper {
    fun productCreationDtoToProduct(creationDto: ProductCreationDto): Product
    fun productToProductDto(product: Product): ProductDto
    fun productToSimpleProductDto(product: Product): SimpleProductDto
    fun productToProductCreatedEvt(product: Product): ProductCreatedEvt
}
