package com.eos_gnss.bellapp

import android.app.Application
import com.eos_gnss.bellapp.data.CarStore
import com.eos_gnss.bellapp.data.CarStoreImpl
import com.eos_gnss.bellapp.module.repositories
import com.eos_gnss.bellapp.module.viewModels
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Application: Application() {

    override fun onCreate() {
        super.onCreate()
        initializeKoin()
    }

    private fun initializeKoin() {
        startKoin {
            androidContext(applicationContext)
            modules(
                listOf(
                    viewModels,
                    repositories
                )
            )
        }
    }

}