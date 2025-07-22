package com.cscorner.data.repository

import com.cscorner.domain.model.AddressDomainModel
import com.cscorner.domain.model.OrdersListModel
import com.cscorner.domain.network.NetworkService
import com.cscorner.domain.network.ResultWrapper
import com.cscorner.domain.repository.OrderRepository

class OrderRepositoryImpl(private val networkService: NetworkService) : OrderRepository {

    override suspend fun placeOrder(
        addressDomainModel: AddressDomainModel,
        userId: Long
    ): ResultWrapper<Long> {
        return networkService.placeOrder(addressDomainModel, userId)
    }

    override suspend fun getOrderList(userId: Long): ResultWrapper<OrdersListModel> {
        return networkService.getOrderList(userId)
    }
}