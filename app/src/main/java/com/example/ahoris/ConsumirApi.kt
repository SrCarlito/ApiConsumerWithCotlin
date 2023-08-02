package com.example.ahoris

import retrofit2.Call
import retrofit2.http.GET

interface ConsumirApi {
    @GET("posts/")

    fun getTraer() : Call<Posts>




}