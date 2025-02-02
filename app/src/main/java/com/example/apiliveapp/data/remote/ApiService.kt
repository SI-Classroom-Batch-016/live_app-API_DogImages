package com.example.apiliveapp.data.remote

import com.example.apiliveapp.data.model.BildListResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


const val BASE_URL = "https://dog.ceo/api/breed/"


val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface ApiService {

    @GET("hound/images")
    suspend fun loadImages() : BildListResponse


}

object DogApi {
    val apiService: ApiService by lazy { retrofit.create(ApiService::class.java) }
}





