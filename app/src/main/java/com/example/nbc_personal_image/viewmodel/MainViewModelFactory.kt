package com.example.nbc_personal_image.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.nbc_personal_image.retrofit.NetWorkInterface

class MainViewModelFactory (
    private val imageSearchRepository: NetWorkInterface
) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
       if(modelClass.isAssignableFrom(MainViewModel::class.java)){
           return MainViewModel(imageSearchRepository) as T
       }
        throw IllegalArgumentException("ViewModel class not found")
    }
}