package com.cscorner.domain.usecase

import com.cscorner.domain.repository.CategoryRepository

class GetCategoriesUseCase(private val repository: CategoryRepository) {
    suspend fun execute() = repository.getCategories()
}