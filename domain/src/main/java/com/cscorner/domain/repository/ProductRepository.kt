package com.cscorner.domain.repository

import com.cscorner.domain.model.Product
import com.cscorner.domain.network.ResultWrapper


interface ProductRepository {
    suspend fun getProducts(category: String?): ResultWrapper<List<Product>>
}