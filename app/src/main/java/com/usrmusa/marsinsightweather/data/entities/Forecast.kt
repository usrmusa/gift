package com.usrmusa.marsinsightweather.data.entities


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Entity(
    tableName = "forecast"
)
data class Forecast(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val date: String,
    val humidity: Int,
    val safe: Boolean,
    val temp: Double,
    val windSpeed: Int
)