package com.example.mymusicplayer

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface Apiinterface {

    @Headers("x-rapidapi-key: c48ee1bfd9msh15323cba780d208p1f4663jsne4286802917d" + "x-rapidapi-host: deezerdevs-deezer.p.rapidapi.com")
    @GET("search")
    fun getData(@Query("q") query: String) : Call<MyData>

}