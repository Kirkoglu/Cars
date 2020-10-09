package com.anzelmas.cars.data

import com.anzelmas.cars.utilities.WEB_SERVICE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {
    val client = OkHttpClient
        .Builder()
        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl(WEB_SERVICE_URL)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
        .create(TmdbEndpoints::class.java)

    fun buildService(): TmdbEndpoints {
        return retrofit

    }
}