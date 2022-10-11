package com.eos_gnss.bellapp.data


data class Car(
    val consList: List<String>,
    val customerPrice: Double,
    val make: String,
    val marketPrice: Double,
    val model: String,
    val prosList: List<String>,
    val rating: Float,
    val imageUrl: Int
)
