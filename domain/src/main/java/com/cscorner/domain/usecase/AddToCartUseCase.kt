package com.cscorner.domain.usecase

import com.cscorner.domain.model.request.AddCartRequestModel
import com.cscorner.domain.repository.CartRepository

class AddToCartUseCase(private val cartRepository: CartRepository) {
    suspend fun execute(request: AddCartRequestModel, userId: Long) =
        cartRepository.addProductToCart(request, userId)
}