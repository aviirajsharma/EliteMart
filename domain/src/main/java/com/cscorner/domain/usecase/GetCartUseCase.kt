package com.cscorner.domain.usecase

import com.cscorner.domain.repository.CartRepository


class GetCartUseCase(val cartRepository: CartRepository) {
    suspend fun execute(userId: Long) = cartRepository.getCart(userId)
}