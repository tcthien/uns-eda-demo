package com.tma.training.sme.smeedaecom.apis.products

import com.tma.training.sme.smeedaecom.apis.products.dtos.ProductCreationDto
import com.tma.training.sme.smeedaecom.apis.products.dtos.ProductDto
import com.tma.training.sme.smeedaecom.apis.products.dtos.SimpleProductDto
import com.tma.training.sme.smeedaecom.businesses.boundaries.products.CreateProduct
import com.tma.training.sme.smeedaecom.businesses.boundaries.products.DeleteProduct
import com.tma.training.sme.smeedaecom.businesses.boundaries.products.SearchProduct
import com.tma.training.sme.smeedaecom.commons.dtos.SuccessDto
import org.slf4j.LoggerFactory
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api/products", produces = [MediaType.APPLICATION_JSON_VALUE])
class ProductResource(
    private val createProduct: CreateProduct,
    private val searchProduct: SearchProduct,
    private val deleteProduct: DeleteProduct,
) {
    companion object {
        private val log = LoggerFactory.getLogger(ProductResource::class.java)
    }

    @PostMapping("")
    fun createProduct(
        @Valid @RequestBody productCreationDto: ProductCreationDto,
    ): ProductDto = createProduct.execute(CreateProduct.Request(productCreationDto)).productDto

    @DeleteMapping("/{productId}")
    fun deleteProduct(
        @PathVariable productId: String
    ): SuccessDto {
        deleteProduct.execute(DeleteProduct.Request(productId))
        return SuccessDto()
    }

    @GetMapping("/{productId}")
    fun getProduct(
        @PathVariable productId: String
    ): ProductDto = searchProduct.execute(SearchProduct.IdRequest(productId)).product

    @GetMapping("")
    fun getProducts(
    ): List<SimpleProductDto> = searchProduct.execute(SearchProduct.Request()).products
}
