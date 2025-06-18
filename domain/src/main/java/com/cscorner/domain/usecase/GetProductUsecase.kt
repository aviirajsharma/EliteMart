package com.cscorner.domain.usecase

import com.cscorner.domain.repository.ProductRepository

class GetProductUseCase(private val repository: ProductRepository) {
    suspend fun execute(category: Int?) = repository.getProducts(category)
}