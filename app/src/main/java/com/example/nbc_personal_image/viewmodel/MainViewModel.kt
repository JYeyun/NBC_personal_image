package com.example.nbc_personal_image.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nbc_personal_image.data.ImageResponse
import com.example.nbc_personal_image.retrofit.NetWorkInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainViewModel(private val imageSearchRepository: NetWorkInterface) : ViewModel() {
   private val _searchResult = MutableLiveData<ImageResponse>()
    val searchResult : MutableLiveData<ImageResponse> get() = _searchResult

    fun searchImage(query : String) = viewModelScope.launch(Dispatchers.IO){
        val response = imageSearchRepository.searchImage( query, "accuracy", 1, 15)
        if(response.isSuccessful){
            response.body().let {
                _searchResult.postValue(it)
            }
        }
    }
}