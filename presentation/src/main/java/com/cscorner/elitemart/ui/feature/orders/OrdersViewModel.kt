package com.cscorner.elitemart.ui.feature.orders

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cscorner.domain.model.OrdersData
import com.cscorner.domain.network.ResultWrapper
import com.cscorner.domain.usecase.OrdersListUseCase
import com.cscorner.elitemart.ShopperSession
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class OrdersViewModel(
    private val ordersListUseCase: OrdersListUseCase,
    private val shopperSession: ShopperSession
) : ViewModel() {

    private val _ordersEvent  = MutableStateFlow<OrdersEvent>(OrdersEvent.Loading)
    val orderEvent = _ordersEvent.asStateFlow()
    val userDomainModel = shopperSession.getUser()
    init {
        getOrderList()
    }

    fun filterOrders(list: List<OrdersData>, filter: String) :List<OrdersData>{
        val filterList = list.filter { it.status == filter }
        return filterList
    }


    private fun getOrderList(){
        viewModelScope.launch {
            val result = ordersListUseCase.execute(userDomainModel!!.id!!.toLong())

            when(result){
                is com.cscorner.domain.network.ResultWrapper.Success -> {
                    val data = result.value
                    _ordersEvent.value = OrdersEvent.Success(data.data)
                }
                is com.cscorner.domain.network.ResultWrapper.Failure ->{
                    _ordersEvent.value = OrdersEvent.Error("Something went wrong")
                }
            }
        }
    }
}


sealed class OrdersEvent {
    object Loading : OrdersEvent()
    data class Success(val data: List<OrdersData>) : OrdersEvent()
    data class Error(val error: String) : OrdersEvent()
}