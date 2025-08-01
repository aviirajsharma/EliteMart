package com.cscorner.elitemart.di

import com.cscorner.elitemart.ShopperSession
import org.koin.dsl.module
val presentationModule = module {
    includes(viewModelModule)
    single { ShopperSession(get()) }
}