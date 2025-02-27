package com.pradip.shoppingcart.domain.usecase

import com.pradip.shoppingcart.data.entities.ProductEntity
import com.pradip.shoppingcart.domain.Resource
import com.pradip.shoppingcart.domain.repository.ProductListRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductListUseCase @Inject constructor(private val productListRepository: ProductListRepository){

    operator fun  invoke() : Flow<Resource<List<ProductEntity>>> = productListRepository.getProductList()
}