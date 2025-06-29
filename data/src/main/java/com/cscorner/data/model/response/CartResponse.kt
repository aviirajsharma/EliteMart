package com.cscorner.data.model.response

import kotlinx.serialization.Serializable

@Serializable
data class CartResponse(
    val data : List<CartItem>,
    val msg : String
){
    fun toCartModel(): com.cscorner.domain.model.CartModel{
        return com.cscorner.domain.model.CartModel(
            data = data.map { it.toCartItemModel() },
            msg = msg
        )
    }
}