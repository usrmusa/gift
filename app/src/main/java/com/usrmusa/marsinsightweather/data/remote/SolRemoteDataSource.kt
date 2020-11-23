package com.usrmusa.marsinsightweather.data.remote

import javax.inject.Inject

class SolRemoteDataSource @Inject constructor(
    private val solService: SolService
) : BaseDataSource() {

    suspend fun getSols() = getResult { solService.getAllSols() }
    suspend fun getSol(id: Int) = getResult {
        solService.getSol(id)
    }
}