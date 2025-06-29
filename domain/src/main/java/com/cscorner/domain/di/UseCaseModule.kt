package com.cscorner.domain.di

import com.cscorner.domain.usecase.AddToCartUseCase
import com.cscorner.domain.usecase.GetCartUseCase
import com.cscorner.domain.usecase.GetCategoriesUseCase
import com.cscorner.domain.usecase.GetProductUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetProductUseCase(get()) }
    factory { GetCategoriesUseCase(get()) }
    factory { AddToCartUseCase(get()) }
    factory { GetCartUseCase(get()) }
}