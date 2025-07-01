package com.cscorner.data.model.response

import kotlinx.serialization.Serializable

@Serializable
data class Summary(
    val discount: Double,
    val items: List<CartItem>,
    val shipping: Double,
    val subtotal: Double,
    val tax: Double,
    val total: Double
){
    fun toSummaryData() = com.cscorner.domain.model.SummaryData(
        discount = discount,
        items = items.map { it.toCartItemModel() },
        shipping = shipping,
        subtotal = subtotal,
        tax = tax,
        total = total
    )
}
