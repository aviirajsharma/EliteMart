package com.cscorner.elitemart.di

import com.cscorner.elitemart.ui.feature.cart.CartViewModel
import com.cscorner.elitemart.ui.feature.home.HomeViewModel
import com.cscorner.elitemart.ui.feature.product_details.ProductDetailsViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel{
        HomeViewModel(get(), get())
    }
    viewModel {
        ProductDetailsViewModel(get())
    }
    viewModel {
        CartViewModel(get())
    }
}