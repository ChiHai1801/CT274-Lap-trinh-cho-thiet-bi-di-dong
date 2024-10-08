package com.example.b1906314_buichihai_api


import retrofit2.Call
import retrofit2.http.GET


interface ApiRequests {
    @GET("fact")
    fun getFact(): Call<CatJSON>
}