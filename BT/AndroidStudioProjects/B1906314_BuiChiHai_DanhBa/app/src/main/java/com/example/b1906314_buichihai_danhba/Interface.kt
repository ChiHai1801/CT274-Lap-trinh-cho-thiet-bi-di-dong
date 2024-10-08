package com.example.b1906314_buichihai_danhba

import retrofit2.Call
import retrofit2.http.GET

interface Interface {
    @GET("api/?results=10")
    fun getQuotes(): Call<ResponesData>
}