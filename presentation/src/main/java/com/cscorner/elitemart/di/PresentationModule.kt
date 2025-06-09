package com.cscorner.elitemart.di

import org.koin.dsl.module
val presentationModule = module {
    includes(viewModelModule)
}