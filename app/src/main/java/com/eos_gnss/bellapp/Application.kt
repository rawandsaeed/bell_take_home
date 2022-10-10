package com.eos_gnss.bellapp

import android.app.Application

class Application: Application() {

    private var carStore: CarStore? = null

    fun getCarStore(): CarStore? {
        if(carStore == null) {
            carStore = CarStoreImpl(applicationContext)
        }
        return carStore
    }

}