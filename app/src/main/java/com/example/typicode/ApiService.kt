package com.example.typicode

import retrofit2.http.GET

interface ApiService {
    @GET("photos")
    suspend fun getPhotos(): List<PhotoList>
}