package com.anzelmas.cars.data

data class PopularCars(
    val cars: List<Car>
)

data class Car(
    val id: Int,
    val numberPlate: String,
    val location: String,
    val model: String,
    val rate: String,
    val reservation: Double,
    val batteryPercentage: Int
)