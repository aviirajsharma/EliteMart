package com.cscorner.elitemart.ui.feature.account.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cscorner.domain.network.ResultWrapper
import com.cscorner.domain.usecase.RegisterUseCase
import com.cscorner.elitemart.ShopperSession
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class RegisterViewModel(
    private val registerUseCase: RegisterUseCase
) : ViewModel() {
    private val _registerState = MutableStateFlow<RegisterState>(RegisterState.Idle)
    val registerState = _registerState


    fun register(email: String, password: String, name: String) {
        viewModelScope.launch {
            val response = registerUseCase.execute(email, password, name)
            when (response) {
                is ResultWrapper.Success -> {
                    ShopperSession.storeUser(response.value)
                    _registerState.value = RegisterState.Success()
                }

                is ResultWrapper.Failure -> {
                    _registerState.value =
                        RegisterState.Error(response.exception.message ?: "Something went wrong")
                }
            }
        }

    }
}


sealed class RegisterState() {
    object Idle : RegisterState()
    object Loading : RegisterState()
    class Success : RegisterState()
    data class Error(val message: String) : RegisterState()
}
