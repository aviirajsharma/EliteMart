package com.cscorner.elitemart.ui.feature.summary

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cscorner.domain.model.CartSummary
import com.cscorner.domain.network.ResultWrapper
import com.cscorner.domain.usecase.CartSummaryUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CartSummaryViewModel(private val cartSummaryUseCase: CartSummaryUseCase): ViewModel(){
    private val _uiState = MutableStateFlow<CartSummaryEvent>(CartSummaryEvent.Loading)
    val uiState = _uiState.asStateFlow()


    init {
        getCartSummary(1)
    }


    private fun getCartSummary(userId: Int){
        viewModelScope.launch {
            val summary = cartSummaryUseCase.execute(userId)
            when(summary){
                is com.cscorner.domain.network.ResultWrapper.Success -> {
                    _uiState.value = CartSummaryEvent.Success(summary.value)
                }
                is com.cscorner.domain.network.ResultWrapper.Failure -> {
                    _uiState.value = CartSummaryEvent.Error(summary.exception.message ?: "Something went wrong")
                }
            }
        }
    }
}

sealed class CartSummaryEvent{
    data object Loading : CartSummaryEvent()
    data class Error(val message: String): CartSummaryEvent()
    data class Success(val summary: CartSummary) : CartSummaryEvent()
}