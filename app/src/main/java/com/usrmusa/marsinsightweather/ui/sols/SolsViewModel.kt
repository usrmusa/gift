package com.usrmusa.marsinsightweather.ui.sols

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.usrmusa.marsinsightweather.data.repository.SolRepository

class SolsViewModel  @ViewModelInject constructor(
    private val repository: SolRepository
): ViewModel() {
    val sols = repository.getSols()
}