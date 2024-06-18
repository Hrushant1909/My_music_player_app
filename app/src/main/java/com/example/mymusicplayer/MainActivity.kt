package com.example.mymusicplayer

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://deezerdevs-deezer.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(Apiinterface::class.java)

        val retrofitData = retrofitBuilder.getData("eminem")
        retrofitData.enqueue(object : Callback<MyData?> {

            override fun onResponse(p0: Call<MyData?>, p1: Response<MyData?>) {
                TODO("Not yet implemented")
            }

            override fun onFailure(p0: Call<MyData?>, p1: Throwable) {
                TODO("Not yet implemented")
            }
        })

        }
    }
