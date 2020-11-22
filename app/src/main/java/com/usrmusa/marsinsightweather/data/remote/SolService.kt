package com.usrmusa.marsinsightweather.data.remote

import com.usrmusa.marsinsightweather.data.entities.SolObject
import retrofit2.Response
import retrofit2.http.GET

//https://api.nasa.gov/insight_weather/?api_key=yXxbu5VnC6lh3ZRyNxhqkStRjl5gh1N6B7Joa1fG&feedtype=json&ver=1.0
//https://raw.githubusercontent.com/usrmusa/data/main/schema

interface SolService {
    @GET("insight_weather/?api_key=yXxbu5VnC6lh3ZRyNxhqkStRjl5gh1N6B7Joa1fG&feedtype=json&ver=1.0")
    suspend fun getAllSols() : Response<SolObject>
}