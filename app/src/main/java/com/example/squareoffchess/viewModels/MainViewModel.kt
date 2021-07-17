package com.example.squareoffchess.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.squareoffchess.ui.UiVisibilityController
import com.example.squareoffchess.ui.CardsAdapter
import com.example.squareoffchess.utils.Repository
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel(private val repository: Repository) : ViewModel() {
    private val _adapter = MutableLiveData<CardsAdapter>()
    val adapter get() = _adapter
    val uiController= UiVisibilityController()
    val isOnline=MutableLiveData<Boolean>(false)
    private var isDataAvailable=false
    init {
        isOnline.observeForever { online ->
            if (!isDataAvailable) {
                if (online) {
                    viewModelScope.launch {
                        fetchData()
                    }
                } else {
                    uiController.showError("No Internet!")
                }
            }
        }
    }
    private suspend fun fetchData(){
            try {
                uiController.showProgress()
                adapter.value = CardsAdapter(repository.getCardData())
                isDataAvailable=true
                uiController.showContent()
            } catch (e: Exception) {
                isDataAvailable=false
                uiController.showError("Something Went Wrong!")
            }
    }
}