@file:Suppress("UNCHECKED_CAST")

package com.example.squareoffchess.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.squareoffchess.viewModels.MainViewModel

class MyViewModelFactory(private val repository: Repository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass==MainViewModel::class.java)
            return MainViewModel(repository) as T
        else throw ClassNotFoundException()
    }
}