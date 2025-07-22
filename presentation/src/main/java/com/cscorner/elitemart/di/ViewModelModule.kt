package com.cscorner.elitemart.di

import com.cscorner.elitemart.ui.feature.account.login.LoginViewModel
import com.cscorner.elitemart.ui.feature.account.register.RegisterViewModel
import com.cscorner.elitemart.ui.feature.cart.CartViewModel
import com.cscorner.elitemart.ui.feature.home.HomeViewModel
import com.cscorner.elitemart.ui.feature.orders.OrdersViewModel
import com.cscorner.elitemart.ui.feature.product_details.ProductDetailsViewModel
import com.cscorner.elitemart.ui.feature.summary.CartSummaryViewModel
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
        CartViewModel(get(), get(), get())
    }
    viewModel {
        CartSummaryViewModel(get(), get())
    }
    viewModel {
        OrdersViewModel(get())
    }
    viewModel {
        LoginViewModel(get())
    }
    viewModel {
        RegisterViewModel(get())
    }
}