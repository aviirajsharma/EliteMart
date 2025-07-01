package com.cscorner.elitemart.navigation

import com.cscorner.domain.model.Product
import com.cscorner.elitemart.model.UiProductModel
import kotlinx.serialization.Serializable


@Serializable
object HomeScreen

@Serializable
object CartScreen

@Serializable
object ProfileScreen

@Serializable
object CartSummaryScreen

@Serializable
data class ProductDetails(val product: UiProductModel)