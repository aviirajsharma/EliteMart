package com.cscorner.domain.usecase

import com.cscorner.domain.repository.CartRepository

class CartSummaryUseCase ( private val repository: CartRepository) {
    suspend fun execute(userId: Long) = repository.getCartSummary(userId)
}