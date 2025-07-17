package com.cscorner.domain.repository

import com.cscorner.domain.model.AddressDomainModel
import com.cscorner.domain.model.OrdersListModel
import com.cscorner.domain.network.ResultWrapper

interface OrderRepository {
    suspend fun placeOrder(addressDomainModel: AddressDomainModel): ResultWrapper<Long>
    suspend fun getOrderList(): ResultWrapper<OrdersListModel>
}