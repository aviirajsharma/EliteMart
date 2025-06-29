package com.cscorner.domain.network

import com.cscorner.domain.model.CartItemModel
import com.cscorner.domain.model.CartModel
import com.cscorner.domain.model.CategoriesListModel
import com.cscorner.domain.model.ProductListModel
import com.cscorner.domain.model.request.AddCartRequestModel

interface NetworkService {
    suspend fun getProducts(category: Int?): ResultWrapper<ProductListModel>
    suspend fun getCategories(): ResultWrapper<CategoriesListModel>

    suspend fun addProductToCart(
        request: AddCartRequestModel
    ): ResultWrapper<CartModel>

    suspend fun getCart(): ResultWrapper<CartModel>
}

sealed class ResultWrapper<out T> {
    data class Success<out T>(val value: T) : ResultWrapper<T>()
    data class Failure(val exception: Exception) : ResultWrapper<Nothing>()
}