package com.tma.training.sme.smeedaecom.businesses.interactors

import com.tma.training.sme.smeedaecom.apis.products.dtos.ProductDeletedEvt
import com.tma.training.sme.smeedaecom.businesses.boundaries.products.CreateProduct
import com.tma.training.sme.smeedaecom.businesses.boundaries.products.DeleteProduct
import com.tma.training.sme.smeedaecom.businesses.boundaries.products.SearchProduct
import com.tma.training.sme.smeedaecom.businesses.services.ProductMapper
import com.tma.training.sme.smeedaecom.businesses.services.ProductService
import com.tma.training.sme.smeedaecom.rabbitmq.EcomEventConstants
import com.tma.training.sme.smeedaecom.rabbitmq.RabbitMQEventBroadcaster
import org.springframework.stereotype.Component

@Component
class GeneralProductInteractor(
    private val productMapper: ProductMapper,
    private val productService: ProductService,
    private val eventBroadcaster: RabbitMQEventBroadcaster,
) : CreateProduct, SearchProduct, DeleteProduct {

    override fun execute(request: CreateProduct.Request): CreateProduct.Response {
        val product = productService.save(productMapper.productCreationDtoToProduct(request.creationDto))
        eventBroadcaster.send(
            event = productMapper.productToProductCreatedEvt(product),
            eventType = EcomEventConstants.EVENT__PRODUCT_CREATION,
        )
        return CreateProduct.Response(productMapper.productToProductDto(product))
    }

    override fun execute(request: DeleteProduct.Request) {
        productService.deleteById(request.productId)
        eventBroadcaster.send(
            event = ProductDeletedEvt(request.productId),
            eventType = EcomEventConstants.EVENT__PRODUCT_DELETE,
        )
    }

    override fun execute(request: SearchProduct.IdRequest): SearchProduct.ProductDetailResponse {
        val product = productService.findById(request.productId)
        return SearchProduct.ProductDetailResponse(productMapper.productToProductDto(product))
    }

    override fun execute(request: SearchProduct.Request): SearchProduct.Response {
        val products = productService.findAll()
        return SearchProduct.Response(products.map(productMapper::productToSimpleProductDto))
    }
}