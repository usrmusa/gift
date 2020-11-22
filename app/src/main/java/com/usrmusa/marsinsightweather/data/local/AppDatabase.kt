package com.usrmusa.marsinsightweather.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.usrmusa.marsinsightweather.data.entities.Sol

@Database(entities = [Sol::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun solDao(): SolDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase =
            instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also {
                    instance = it
                }
            }

        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(appContext, AppDatabase::class.java, "sols")
                .fallbackToDestructiveMigration()
                .build()
    }
}