package com.usrmusa.marsinsightweather.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.usrmusa.marsinsightweather.data.entities.Forecast

@Dao
interface SolDao {

    @Query("SELECT * FROM forecast")
    fun getAllSols() : LiveData<List<Forecast>>

    @Query("SELECT * FROM forecast WHERE id = :id")
    fun getSol(id: Int): LiveData<Forecast>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(sols: List<Forecast>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(sol: Forecast)
}