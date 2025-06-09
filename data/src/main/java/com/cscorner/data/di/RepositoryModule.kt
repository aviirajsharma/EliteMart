package com.cscorner.data.di

import com.cscorner.data.repository.ProductRepositoryImpl
import com.cscorner.domain.repository.ProductRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<ProductRepository> { ProductRepositoryImpl(get()) }
}