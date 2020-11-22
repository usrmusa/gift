package com.usrmusa.marsinsightweather.ui.soldetail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.usrmusa.marsinsightweather.data.repository.SolRepository

class SolDetailViewModel @ViewModelInject constructor(
    private val repository: SolRepository
) : ViewModel() {

    private val _id = MutableLiveData<Int>()

    //    private val _sol = _id.switchMap { id ->
//        repository.getSol(id)
//    }
//    val sol: LiveData<Resource<Sol>> = _sol
    fun start(id: Int) {
        _id.value = id
    }
}