package com.cscorner.data.model.response

import com.cscorner.data.model.DataProductModel
import kotlinx.serialization.Serializable

@Serializable
data class ProductListResponse(
    val `data`: List<DataProductModel>,
    val msg: String
){
    fun toProductList() = com.cscorner.domain.model.ProductListModel(
        products = data.map { it.toProduct() },
        msg = msg
    )
}