package com.example.listadoapp.ui

import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface ActorService {



    @GET("person/popular")
    fun getActores( @Query("api_key")api_key:String,
                    @Query("language")language:String,
                    @Query("page")page:Int): Call<ActoresResponse>

}