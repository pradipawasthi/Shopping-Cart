package com.pradip.shoppingcart.data.services

import com.pradip.shoppingcart.data.entities.ProductEntity
import com.pradip.shoppingcart.domain.Resource
import retrofit2.http.GET

interface ProductService {

    @GET("productList/v1")
    fun getProductList() : List<ProductEntity>
}