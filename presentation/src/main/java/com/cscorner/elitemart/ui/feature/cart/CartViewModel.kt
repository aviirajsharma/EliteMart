package com.cscorner.elitemart.ui.feature.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cscorner.domain.model.CartItemModel
import com.cscorner.domain.usecase.DeleteProductUseCase
import com.cscorner.domain.usecase.GetCartUseCase
import com.cscorner.domain.usecase.UpdateQuantityUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CartViewModel(
    val cartUseCase: GetCartUseCase,
    private val updateQuantityUseCase: UpdateQuantityUseCase,
    private val deleteProductUseCase: DeleteProductUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow<CartEvent>(CartEvent.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        getCart()
    }

    fun getCart() {
        viewModelScope.launch {
            _uiState.value = CartEvent.Loading
            cartUseCase.execute().let { result ->
                when (result) {
                    is com.cscorner.domain.network.ResultWrapper.Success -> {
                        _uiState.value = CartEvent.Success(result.value.data)
                    }

                    is com.cscorner.domain.network.ResultWrapper.Failure -> {
                        _uiState.value = CartEvent.Error("Something went wrong!")
                    }
                }
            }
        }
    }

    fun incrementQuantity(cartItem: CartItemModel) {
        if (cartItem.quantity == 10) return
        updateQuantity(cartItem.copy(quantity = cartItem.quantity + 1))
    }

    fun decrementQuantity(cartItem: CartItemModel) {
        if (cartItem.quantity == 1) return
        updateQuantity(cartItem.copy(quantity = cartItem.quantity - 1))
    }

    private fun updateQuantity(cartItem: CartItemModel) {
        viewModelScope.launch {
            _uiState.value = CartEvent.Loading
            val result = updateQuantityUseCase.execute(cartItem)
            when (result) {
                is com.cscorner.domain.network.ResultWrapper.Success -> {
                    _uiState.value = CartEvent.Success(result.value.data)
                }

                is com.cscorner.domain.network.ResultWrapper.Failure -> {
                    _uiState.value = CartEvent.Error("Something went wrong!")
                }
            }
        }
    }

    fun removeItem(cartItem: CartItemModel) {
        viewModelScope.launch {
            _uiState.value = CartEvent.Loading
            val result = deleteProductUseCase.execute(cartItem.id, 1)
            when (result) {
                is com.cscorner.domain.network.ResultWrapper.Success -> {
                    _uiState.value = CartEvent.Success(result.value.data)
                }
                is com.cscorner.domain.network.ResultWrapper.Failure -> {
                    _uiState.value = CartEvent.Error("Something went wrong!")
                }
            }
        }
    }
}

sealed class CartEvent {
    data object Loading : CartEvent()
    data class Success(val message: List<CartItemModel>) : CartEvent()
    data class Error(val message: String) : CartEvent()
}