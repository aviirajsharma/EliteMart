package com.cscorner.domain.usecase

import com.cscorner.domain.repository.CartRepository


class GetCartUseCase(val cartRepository: CartRepository) {
    suspend fun execute() = cartRepository.getCart()
}