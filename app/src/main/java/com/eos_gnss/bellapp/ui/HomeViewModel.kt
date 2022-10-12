package com.eos_gnss.bellapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eos_gnss.bellapp.data.Car
import com.eos_gnss.bellapp.data.CarStore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException

class HomeViewModel(
    private val carStore: CarStore
): ViewModel() {

    private val _carListLive = MutableLiveData<List<Car>>()
    val carListLive: LiveData<List<Car>> = _carListLive

    init {
        fetchCars()
    }

    private fun fetchCars() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _carListLive.postValue(carStore.getCars())
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

}