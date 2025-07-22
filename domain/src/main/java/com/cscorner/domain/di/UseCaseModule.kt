package com.cscorner.domain.di

import com.cscorner.domain.usecase.AddToCartUseCase
import com.cscorner.domain.usecase.CartSummaryUseCase
import com.cscorner.domain.usecase.DeleteProductUseCase
import com.cscorner.domain.usecase.GetCartUseCase
import com.cscorner.domain.usecase.GetCategoriesUseCase
import com.cscorner.domain.usecase.GetProductUseCase
import com.cscorner.domain.usecase.LoginUseCase
import com.cscorner.domain.usecase.OrdersListUseCase
import com.cscorner.domain.usecase.PlaceOrderUseCase
import com.cscorner.domain.usecase.RegisterUseCase
import com.cscorner.domain.usecase.UpdateQuantityUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetProductUseCase(get()) }
    factory { GetCategoriesUseCase(get()) }
    factory { AddToCartUseCase(get()) }
    factory { GetCartUseCase(get()) }
    factory { UpdateQuantityUseCase(get()) }
    factory { DeleteProductUseCase(get()) }
    factory { CartSummaryUseCase(get()) }
    factory { PlaceOrderUseCase(get()) }
    factory { OrdersListUseCase(get()) }
    factory { LoginUseCase(get()) }
    factory { RegisterUseCase(get()) }

}