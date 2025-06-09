package com.cscorner.elitemart

import android.app.Application
import com.cscorner.data.di.dataModule
import com.cscorner.domain.di.domainModule
import com.cscorner.elitemart.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ShopperApp:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@ShopperApp)
            modules(listOf(
                presentationModule,
                dataModule,
                domainModule
            ))
        }
    }
}