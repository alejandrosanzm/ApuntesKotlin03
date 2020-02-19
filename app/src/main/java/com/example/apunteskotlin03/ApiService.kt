package com.example.apunteskotlin03

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("kotlin.php")
    fun getResponseWithParam(@Query("param") param: Int): Call<List<Pojo>> // O Call<Pojo>, uno solo
}
