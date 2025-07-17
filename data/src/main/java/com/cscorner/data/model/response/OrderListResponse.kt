package com.cscorner.data.model.response

import com.cscorner.domain.model.OrdersListModel
import kotlinx.serialization.Serializable


@Serializable
data class OrderListResponse(
    val `data`: List<OrderListData>,
    val msg: String
) {
    fun toDomainResponse(): OrdersListModel{
        return OrdersListModel(
            `data` = `data`.map { it.toDomainResponse() },
            msg = msg
        )
    }
}