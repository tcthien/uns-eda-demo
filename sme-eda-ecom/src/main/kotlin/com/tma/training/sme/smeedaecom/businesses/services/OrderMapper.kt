package com.tma.training.sme.smeedaecom.businesses.services

import com.tma.training.sme.smeedaecom.apis.orders.dtos.OrderCreatedEvt
import com.tma.training.sme.smeedaecom.apis.orders.dtos.OrderCreationDto
import com.tma.training.sme.smeedaecom.apis.orders.dtos.OrderDto
import com.tma.training.sme.smeedaecom.databases.entities.Order
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface OrderMapper {
    fun orderCreationDtoToOrder(creationDto: OrderCreationDto): Order
    fun orderToOrderDto(order: Order): OrderDto
    fun orderToOrderCreatedEvt(order: Order): OrderCreatedEvt
}
