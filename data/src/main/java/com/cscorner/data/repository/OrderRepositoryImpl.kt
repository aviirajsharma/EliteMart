package com.cscorner.data.repository

import com.cscorner.domain.model.AddressDomainModel
import com.cscorner.domain.model.OrdersListModel
import com.cscorner.domain.network.NetworkService
import com.cscorner.domain.network.ResultWrapper
import com.cscorner.domain.repository.OrderRepository

class OrderRepositoryImpl (private val networkService: NetworkService) : OrderRepository {

    override suspend fun placeOrder(addressDomainModel: AddressDomainModel): ResultWrapper<Long> {
        return networkService.placeOrder(addressDomainModel, 1)
    }

    override suspend fun getOrderList(): ResultWrapper<OrdersListModel> {
        return networkService.getOrderList()
    }
}