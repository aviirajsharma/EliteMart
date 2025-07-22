package com.cscorner.domain.usecase

import com.cscorner.domain.repository.UserRepository

class LoginUseCase(private val userRepository: UserRepository) {
    suspend fun execute(username: String, password: String) =
        userRepository.login(username,password)
}