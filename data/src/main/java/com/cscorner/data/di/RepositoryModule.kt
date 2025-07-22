package com.cscorner.data.di

import com.cscorner.data.repository.CategoryRepositoryImpl
import com.cscorner.data.repository.ProductRepositoryImpl
import com.cscorner.domain.repository.CartRepository
import com.cscorner.domain.repository.CategoryRepository
import com.cscorner.domain.repository.OrderRepository
import com.cscorner.domain.repository.ProductRepository
import com.cscorner.domain.repository.UserRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<ProductRepository> { ProductRepositoryImpl(get()) }
    single<CategoryRepository> { CategoryRepositoryImpl(get()) }
    single<CartRepository> { com.cscorner.data.repository.CartRepositoryImpl(get()) }
    single<OrderRepository> { com.cscorner.data.repository.OrderRepositoryImpl(get()) }
    single<UserRepository> { com.cscorner.data.repository.UserRepositoryImpl(get()) }
}