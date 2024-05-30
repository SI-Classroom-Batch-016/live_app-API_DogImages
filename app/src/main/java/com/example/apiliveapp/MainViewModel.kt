package com.example.apiliveapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apiliveapp.data.Repository
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val repository = Repository()

    val images = repository.images

    fun loadImages() {
        viewModelScope.launch {
            repository.loadImages()
        }
    }
}