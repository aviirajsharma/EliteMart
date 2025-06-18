package com.cscorner.data.repository

import com.cscorner.domain.model.Product
import com.cscorner.domain.model.ProductListModel
import com.cscorner.domain.network.NetworkService
import com.cscorner.domain.network.ResultWrapper
import com.cscorner.domain.repository.ProductRepository

class ProductRepositoryImpl(private val networkService: NetworkService) : ProductRepository {
    override suspend fun getProducts(category: Int?): ResultWrapper<ProductListModel> {
        return networkService.getProducts(category)
    }
}