package com.cscorner.domain.usecase

import com.cscorner.domain.repository.UserRepository

class RegisterUseCase(private val userRepository: UserRepository) {
    suspend fun execute(username: String, password: String, name: String) =
        userRepository.register(username,password, name)
}