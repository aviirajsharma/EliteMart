package com.cscorner.domain.di

import com.cscorner.domain.usecase.GetCategoriesUseCase
import com.cscorner.domain.usecase.GetProductUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetProductUseCase(get()) }
    factory { GetCategoriesUseCase(get()) }
}