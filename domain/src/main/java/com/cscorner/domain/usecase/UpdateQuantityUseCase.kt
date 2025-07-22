package com.cscorner.domain.usecase

import com.cscorner.domain.model.CartItemModel
import com.cscorner.domain.repository.CartRepository

class UpdateQuantityUseCase(private val cartRepository: CartRepository) {
    suspend fun execute(cartItemModel: CartItemModel, userId: Long) =
        cartRepository.updateQuantity(cartItemModel, userId)
}