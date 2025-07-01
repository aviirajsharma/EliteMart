package com.cscorner.data.model.request

import com.cscorner.domain.model.request.AddCartRequestModel
import kotlinx.serialization.Serializable


@Serializable
data class AddToCartRequest(
    val productId: Int,
    val quantity: Int,
) {
    companion object {
        fun fromCartRequestModel(addCartRequestModel: AddCartRequestModel) = AddToCartRequest(
            productId = addCartRequestModel.productId,
            quantity = addCartRequestModel.quantity,
        )
    }
}