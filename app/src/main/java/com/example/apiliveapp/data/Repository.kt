package com.example.apiliveapp.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.apiliveapp.data.remote.DogApi

class Repository {

    private val _images = MutableLiveData<List<String>>()
    val images: LiveData<List<String>>
        get() = _images

    suspend fun loadImages() {
        val response = DogApi.apiService.loadImages()
        Log.d("ApiResponse", response.toString())

        _images.postValue(response.message)
    }

}