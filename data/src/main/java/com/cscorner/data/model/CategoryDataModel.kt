package com.cscorner.data.model

import kotlinx.serialization.Serializable

@Serializable
data class CategoryDataModel(
    val id: Int,
    val image: String,
    val title: String
) {
    fun toCategory() = com.cscorner.domain.model.Category(
        id = id,
        image = image,
        title = title
    )
}