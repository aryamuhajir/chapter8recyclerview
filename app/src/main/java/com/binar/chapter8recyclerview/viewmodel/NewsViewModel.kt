package com.binar.chapter8recyclerview.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.binar.chapter8recyclerview.data.GetAllNewsResponseItem
import com.binar.chapter8recyclerview.data.GetAllStafResponseItem
import com.binar.chapter8recyclerview.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val repository: NewsRepository) : ViewModel() {
    private val newsState = MutableStateFlow(emptyList<GetAllNewsResponseItem>())
    private val staffState = MutableStateFlow(emptyList<GetAllStafResponseItem>())

    val dataState : StateFlow<List<GetAllNewsResponseItem>>
    get() = newsState

    val dataState2 : StateFlow<List<GetAllStafResponseItem>>
    get() = staffState


    init {
        viewModelScope.launch {
            val news = repository.getNews()
            val staf = repository.getStafs()
            newsState.value = news
            staffState.value =  staf
        }
    }


}