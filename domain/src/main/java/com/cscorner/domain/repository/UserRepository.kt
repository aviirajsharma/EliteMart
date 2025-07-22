package com.cscorner.domain.repository

import com.cscorner.domain.model.UserDomainModel
import com.cscorner.domain.network.ResultWrapper

interface UserRepository {

    suspend fun login(email: String, password: String): ResultWrapper<UserDomainModel>
    suspend fun register(
        email: String,
        password: String,
        name: String
    ): ResultWrapper<UserDomainModel>
}