package com.example.apiliveapp

import android.provider.ContactsContract.Data
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.apiliveapp.data.DataSource
import com.example.apiliveapp.data.model.Fact

class MainViewModel : ViewModel() {

    private val _facts = MutableLiveData<List<Fact>>()
    val facts : LiveData<List<Fact>>
        get() = _facts

    fun loadFacts(){
        _facts.value = DataSource.facts
    }

}