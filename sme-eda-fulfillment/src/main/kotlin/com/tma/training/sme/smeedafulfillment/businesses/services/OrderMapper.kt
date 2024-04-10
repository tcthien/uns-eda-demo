package com.tma.training.sme.smeedafulfillment.businesses.services

import com.tma.training.sme.smeedafulfillment.apis.orders.dtos.OrderCreatedEvt
import com.tma.training.sme.smeedafulfillment.apis.orders.dtos.OrderDto
import com.tma.training.sme.smeedafulfillment.apis.orders.dtos.SimpleOrderDto
import com.tma.training.sme.smeedafulfillment.databases.entities.Order
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface OrderMapper {
    fun orderToOrderDto(order: Order): OrderDto
    fun orderToOrderCreatedEvt(order: Order): OrderCreatedEvt
    fun orderCreatedEvtToOrder(orderCreatedEvt: OrderCreatedEvt): Order
    fun orderToSimpleOrderDto(order: Order): SimpleOrderDto
}
