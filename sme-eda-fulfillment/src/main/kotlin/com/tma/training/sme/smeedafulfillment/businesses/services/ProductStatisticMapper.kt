package com.tma.training.sme.smeedafulfillment.businesses.services

import com.tma.training.sme.smeedafulfillment.apis.productstatistic.dtos.ProductStatisticDto
import com.tma.training.sme.smeedafulfillment.databases.entities.ProductStatistic
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface ProductStatisticMapper {
    fun productStatisticToSimpleProductStatisticDto(productStatistic: ProductStatistic): ProductStatisticDto
}
