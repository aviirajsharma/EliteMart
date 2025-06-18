package com.cscorner.domain.repository

import com.cscorner.domain.model.Product
import com.cscorner.domain.model.ProductListModel
import com.cscorner.domain.network.ResultWrapper


interface ProductRepository {
    suspend fun getProducts(category: Int?): ResultWrapper<ProductListModel>
}