package com.pradip.shoppingcart.data.repository

import com.pradip.shoppingcart.data.backendRequestFlow
import com.pradip.shoppingcart.data.entities.ProductEntity
import com.pradip.shoppingcart.data.services.ProductService
import com.pradip.shoppingcart.domain.Resource
import com.pradip.shoppingcart.domain.repository.ProductListRepository
import kotlinx.coroutines.flow.Flow

class ProductListRepositoryImpl(private val productService: ProductService) : ProductListRepository {
    override fun getProductList(): Flow<Resource<List<ProductEntity>>> {

      return  backendRequestFlow {
            productService.getProductList()
        }
    }

}