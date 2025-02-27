package com.pradip.shoppingcart.domain.repository

import com.pradip.shoppingcart.data.entities.ProductEntity
import com.pradip.shoppingcart.domain.Resource
import kotlinx.coroutines.flow.Flow

interface ProductListRepository {
    fun getProductList() : Flow<Resource<List<ProductEntity>>>
}