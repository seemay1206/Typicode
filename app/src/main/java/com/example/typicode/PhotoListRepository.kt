package com.example.typicode

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PhotoListRepository @Inject constructor(private val apiService: ApiService)
{
        suspend fun getPhotos() = apiService.getPhotos()
}