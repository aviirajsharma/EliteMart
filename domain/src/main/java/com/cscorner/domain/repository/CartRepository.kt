package com.cscorner.domain.repository

import com.cscorner.domain.model.CartItemModel
import com.cscorner.domain.model.CartModel
import com.cscorner.domain.model.CartSummary
import com.cscorner.domain.model.request.AddCartRequestModel
import com.cscorner.domain.network.ResultWrapper

interface CartRepository {
    suspend fun addProductToCart(
        request: AddCartRequestModel,
        userId: Long
    ): ResultWrapper<CartModel>

    suspend fun getCart(userId: Long): ResultWrapper<CartModel>
    suspend fun updateQuantity(cartItemModel: CartItemModel,userId: Long): ResultWrapper<CartModel>
    suspend fun deleteItem(cartItemId: Int, userId: Long): ResultWrapper<CartModel>
    suspend fun getCartSummary(userId: Long): ResultWrapper<CartSummary>
}