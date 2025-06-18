package com.cscorner.data.model.response

import com.cscorner.data.model.CategoryDataModel
import kotlinx.serialization.Serializable

@Serializable
data class CategoriesListResponse(
    val `data`: List<CategoryDataModel>,
    val msg: String
){
    fun toCategoriesList() = com.cscorner.domain.model.CategoriesListModel(
        categories = data.map { it.toCategory() },
        msg = msg
    )
}