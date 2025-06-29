package com.cscorner.data.repository

import com.cscorner.domain.model.CartItemModel
import com.cscorner.domain.model.CartModel
import com.cscorner.domain.model.request.AddCartRequestModel
import com.cscorner.domain.network.NetworkService
import com.cscorner.domain.network.ResultWrapper
import com.cscorner.domain.repository.CartRepository

class CartRepositoryImpl(val networkService : NetworkService): CartRepository {
    override suspend fun addProductToCart(request: AddCartRequestModel): ResultWrapper<CartModel> {
        return networkService.addProductToCart(request)
    }

    override suspend fun getCart(): ResultWrapper<CartModel> {
        return networkService.getCart()
    }
}