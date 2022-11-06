package com.example.win10.api


import com.example.win10.model.AppsModel
import com.example.win10.model.MultibettingModel
import com.example.win10.model.TipsModel
import retrofit2.Call
import retrofit2.http.GET

interface InterfaceApi {
    @GET("/win10/tips.json")
    fun getTips(): Call<TipsModel>
    @GET("/win10/licensed_app.json")
    fun getApps(): Call<AppsModel>
    @GET("/win10/multibetting.json")
    fun getMultibet(): Call<MultibettingModel>
}