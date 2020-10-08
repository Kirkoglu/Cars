package com.anzelmas.cars.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cars")
data class Car (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val plateNumber: String,
    val location: String,
    val model: String,
    val rate: String,
    val reservation: Double,
    val batteryPercentage: Int
)