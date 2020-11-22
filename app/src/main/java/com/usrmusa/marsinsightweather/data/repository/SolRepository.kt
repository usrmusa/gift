package com.usrmusa.marsinsightweather.data.repository

import com.usrmusa.marsinsightweather.data.local.SolDao
import com.usrmusa.marsinsightweather.data.remote.SolRemoteDataSource
import com.usrmusa.marsinsightweather.utils.performGetOperation
import javax.inject.Inject

class SolRepository @Inject constructor(
    private val remoteDataSource: SolRemoteDataSource,
    private val localDataSource: SolDao
) {
    fun getSols() = performGetOperation(
        databaseQuery = { localDataSource.getAllSols() },
        networkCall = { remoteDataSource.getSols() },
        saveCallResult = { localDataSource.insertAll(it.x700) }
    )
}