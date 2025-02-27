package com.pradip.shoppingcart.ui.product

import androidx.lifecycle.ViewModel
import com.pradip.shoppingcart.data.entities.ProductEntity
import com.pradip.shoppingcart.domain.usecase.ProductListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(private val productListUseCase: ProductListUseCase) : ViewModel() {

    private  val _uiState = MutableStateFlow<ProductState>(ProductState())
    val uiState: StateFlow<ProductState> = _uiState.asStateFlow()

    init {
        getProductList()
    }


     fun getProductList(){


    }
}

data class ProductState(
    val product : List<ProductEntity>? = null,
    val loading  : Boolean? = false,
    val error : String? = null

)
