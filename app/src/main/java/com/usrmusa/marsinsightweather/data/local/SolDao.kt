package com.usrmusa.marsinsightweather.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.usrmusa.marsinsightweather.data.entities.Sol

@Dao
interface SolDao {

    @Query("SELECT * FROM sols")
    fun getAllSols() :  LiveData<List<Sol>>

    @Query("SELECT * FROM sols WHERE id = :id")
    fun getSol(id: Int): LiveData<Sol>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(sols: Sol)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(sol: Sol)
}