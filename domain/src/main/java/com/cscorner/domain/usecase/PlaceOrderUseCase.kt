package com.cscorner.domain.usecase

import com.cscorner.domain.model.AddressDomainModel
import com.cscorner.domain.repository.OrderRepository

class PlaceOrderUseCase(val orderRepository: OrderRepository) {
    suspend fun execute(addressDomainModel: AddressDomainModel, userId: Long) =
        orderRepository.placeOrder(addressDomainModel, userId)
}