package com.eos_gnss.bellapp

import android.app.Application
import com.eos_gnss.bellapp.data.CarStore
import com.eos_gnss.bellapp.data.CarStoreImpl

class Application: Application() {

    private var carStore: CarStore? = null

    fun getCarStore(): CarStore? {
        if(carStore == null) {
            carStore = CarStoreImpl(applicationContext)
        }
        return carStore
    }

}