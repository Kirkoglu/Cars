package com.anzelmas.cars.data

import android.database.Observable
import retrofit2.http.GET

interface TmdbEndpoints {
    @GET("availablecars")
    fun getAvailableCars(WEB_SERVICE_URL: String): Observable<Car>
}