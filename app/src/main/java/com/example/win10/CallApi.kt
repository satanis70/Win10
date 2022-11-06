package com.example.win10

import com.example.win10.api.InterfaceApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CallApi {
    fun api(): InterfaceApi {
        val api = Retrofit.Builder()
            .baseUrl("http://49.12.202.175/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(InterfaceApi::class.java)
        return api
    }
}