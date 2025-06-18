package com.cscorner.domain.network

import com.cscorner.domain.model.Product
import com.cscorner.domain.model.ProductListModel

interface NetworkService {
    suspend fun getProducts(category: Int?) : ResultWrapper<ProductListModel>
    suspend fun getCategories() : ResultWrapper<List<String>>
}

sealed class ResultWrapper<out T>{
    data class Success<out T>(val value: T) : ResultWrapper<T>()
    data class Failure(val exception: Exception) : ResultWrapper<Nothing>()
}