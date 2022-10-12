package com.eos_gnss.bellapp.data

import android.content.Context
import android.content.res.AssetManager
import com.eos_gnss.bellapp.R
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.util.*

class CarStoreImpl(private val applicationContext: Context): CarStore {

    companion object {
        private const val SOURCE_FILE_NAME = "car_list.json"
    }

    override fun getCars(): List<Car> {

        val sourceListOfCar = getRawJsonCarList()

        val newList = LinkedList<Car>()

        sourceListOfCar.forEach {
            when {
                it.make.contains("Alpine") -> {
                    newList.add(it.copy(imageUrl = R.drawable.alpine_roadster))
                }
                it.make.contains("Mercedes Benz") -> {
                    newList.add(it.copy(imageUrl = R.drawable.mercedez_benz_glc))
                }
                it.make.contains("BMW") -> {
                    newList.add(it.copy(imageUrl = R.drawable.bmw_330i))
                }
                it.make.contains("Land Rover") -> {
                    newList.add(it.copy(imageUrl = R.drawable.range_rover))
                }
            }
        }
        return newList
    }

    private fun getRawJsonCarList(): List<Car> {

        val inputString = applicationContext.assets.readFile(SOURCE_FILE_NAME)

        return GsonBuilder().create()
            .fromJson(inputString, object : TypeToken<List<Car>>() {}.type)
    }

}

/*
* An extension function to read the file from AssetManager class
* */
fun AssetManager.readFile(fileName: String) = open(fileName)
    .bufferedReader()
    .use {
        it.readText()
    }