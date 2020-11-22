package com.usrmusa.marsinsightweather.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity (
    tableName = "sols"
)
data class Sol(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
//    val AT: AT,
    val First_UTC: String,
//    val HWS: HWS,
    val Last_UTC: String,
//    val PRE: PRE,
    val Season: String,
//    val WD: WD
)