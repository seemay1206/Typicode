package com.example.typicode

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotoListViewModel
    @Inject constructor(private val repository: PhotoListRepository) : ViewModel() {

        private val _photos = MutableLiveData<List<PhotoList>>()
        val photos: LiveData<List<PhotoList>> get() = _photos

        init {
            viewModelScope.launch {
                _photos.value = repository.getPhotos()
            }
        }
}