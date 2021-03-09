package com.example.listadoapp.ui

import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Header
import retrofit2.http.Path

interface ActorService {

    @GET("person/popular?api_key={key}")
    fun getActores( @Path("key") key:String): Call<List<Actor>>
}