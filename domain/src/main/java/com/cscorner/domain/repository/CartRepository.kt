package com.cscorner.domain.repository

import com.cscorner.domain.model.CartModel
import com.cscorner.domain.model.request.AddCartRequestModel
import com.cscorner.domain.network.ResultWrapper

interface CartRepository {
    suspend fun addProductToCart(
        request: AddCartRequestModel
    ): ResultWrapper<CartModel>

    suspend fun getCart() : ResultWrapper<CartModel>
}