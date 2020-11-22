package com.usrmusa.marsinsightweather.data.entities


import com.google.gson.annotations.SerializedName

data class SolObject(

    @SerializedName("sol_keys")
    val solKeys: List<String>,

    @SerializedName("700")
    val x700: Sol,
    @SerializedName("701")
    val x701: Sol,
    @SerializedName("703")
    val x703: Sol,
    @SerializedName("704")
    val x704: Sol,
    @SerializedName("705")
    val x705: Sol,
    @SerializedName("706")
    val x706: Sol

)