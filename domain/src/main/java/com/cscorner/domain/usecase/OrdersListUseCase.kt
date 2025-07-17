package com.cscorner.domain.usecase

import com.cscorner.domain.repository.OrderRepository

class OrdersListUseCase(
    private val repository: OrderRepository
) {
    suspend fun execute() = repository.getOrderList()
}
