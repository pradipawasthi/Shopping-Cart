package com.pradip.shoppingcart.ui.product

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pradip.shoppingcart.data.entities.ProductEntity
import com.pradip.shoppingcart.domain.Resource
import com.pradip.shoppingcart.domain.usecase.ProductListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(private val productListUseCase: ProductListUseCase) : ViewModel() {

    private  val _uiState = MutableStateFlow<ProductState>(ProductState())
    val uiState: StateFlow<ProductState> = _uiState.asStateFlow()

    init {
        getProductList()
    }

    private fun getProductList() {
        viewModelScope.launch {
            productListUseCase().collect { result ->
                _uiState.value = when (result) {
                    is Resource.Loading -> {
                        _uiState.value.copy(
                            isLoading = true,
                            error = null
                        )
                    }
                    is Resource.Success -> {
                        _uiState.value.copy(
                            products = result.value,
                            isLoading = false,
                            error = null
                        )
                    }
                    is Resource.Error -> {
                        _uiState.value.copy(
                            isLoading = false,
                            error = result.reason
                        )
                    }
                }
            }
        }
    }

}

data class ProductState(
    val products : List<ProductEntity>? = null,
    val isLoading  : Boolean? = false,
    val error : String? = null

)
