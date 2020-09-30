package com.example.listtoexcel.share

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.listtoexcel.add.WorkDetails

class SharedViewModel: ViewModel() {
    private val _workDetails = MutableLiveData<ArrayList<WorkDetails>>()

    val workDetails: LiveData<ArrayList<WorkDetails>>
        get() = _workDetails

    fun setWorkDetails(value: ArrayList<WorkDetails>) {
        _workDetails.value = value
    }
}