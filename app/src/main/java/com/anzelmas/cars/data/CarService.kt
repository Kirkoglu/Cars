package com.anzelmas.cars.data

import com.anzelmas.cars.utilities.WEB_SERVICE_URL
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface CarService {
    @GET("https://development.espark.lt/api/mobile/public/availablecars")
    fun getCar(): Response<List<Car>>

    companion object {

        fun create(): CarService {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(WEB_SERVICE_URL)
                .build()
            return retrofit.create(CarService::class.java)

        }
    }
}