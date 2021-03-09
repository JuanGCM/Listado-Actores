package com.example.listadoapp.ui.actores

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.listadoapp.ui.Actor
import com.example.listadoapp.ui.ActorService
import com.example.listadoapp.ui.ActoresResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ActoresViewModel :ViewModel(){

    private val _actores = MutableLiveData<List<Actor>>()
    private val baseUrl = "https://api.themoviedb.org/3/"
    private lateinit var service: ActorService

    val actores: LiveData<List<Actor>>
        get() = _actores

    init {
        _actores.value = listOf()

        val retrofitActores = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofitActores.create(ActorService::class.java)
        getActoresList()
    }

    fun getActoresList() {
        service.getActores("f275c22f59e80ed081f9dd89c51370ae","en-US",1).enqueue(object: Callback<ActoresResponse> {
            override fun onResponse(
                call: Call<ActoresResponse>,
                response: Response<ActoresResponse>
            ) {
                if(response.code() == 200) {
                    Log.i("ERROR","Hace la petición")
                    _actores.value = response.body()?.results
                }
            }

            override fun onFailure(call: Call<ActoresResponse>, t: Throwable) {
                // Entra cuando falla la comunicación con el servidor
                Log.i("ERROR",t.message.toString()+" "+t.cause.toString())
            }
        })
    }
}
