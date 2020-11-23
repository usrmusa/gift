package com.usrmusa.marsinsightweather.data.entities


data class ForecastList(
    val forecasts: List<Forecast>,
    val lastUpdated: String,
    val weatherStation: String
)