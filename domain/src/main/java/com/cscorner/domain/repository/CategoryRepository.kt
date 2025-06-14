package com.cscorner.domain.repository

import com.cscorner.domain.network.ResultWrapper

interface CategoryRepository {
    suspend fun getCategories(): ResultWrapper<List<String>>
}