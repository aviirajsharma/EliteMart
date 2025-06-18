package com.cscorner.data.repository

import com.cscorner.domain.model.CategoriesListModel
import com.cscorner.domain.network.NetworkService
import com.cscorner.domain.network.ResultWrapper
import com.cscorner.domain.repository.CategoryRepository

class CategoryRepositoryImpl(val networkService: NetworkService) : CategoryRepository {
    override suspend fun getCategories() : ResultWrapper<CategoriesListModel> {
        return networkService.getCategories()
    }
}