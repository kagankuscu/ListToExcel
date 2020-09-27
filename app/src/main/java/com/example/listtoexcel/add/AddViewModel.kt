package com.example.listtoexcel.add

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddViewModel : ViewModel() {
    private val _workDetails = MutableLiveData<ArrayList<WorkDetails>>()

    val workDetails: LiveData<ArrayList<WorkDetails>>
        get() = _workDetails

    fun setWorkDetails(value: ArrayList<WorkDetails>) {
        _workDetails.value = value
    }
}