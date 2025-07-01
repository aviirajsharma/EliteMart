package com.cscorner.domain.usecase

import com.cscorner.domain.model.CartItemModel
import com.cscorner.domain.repository.CartRepository

class DeleteProductUseCase(private val cartRepository: CartRepository) {
    suspend fun execute(cartItemId: Int, userId: Int) = cartRepository.deleteItem(cartItemId, userId)
}