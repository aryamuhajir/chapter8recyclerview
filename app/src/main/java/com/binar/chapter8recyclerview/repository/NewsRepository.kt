package com.binar.chapter8recyclerview.repository

import com.binar.chapter8recyclerview.api.ApiService
import com.binar.chapter8recyclerview.data.GetAllNewsResponseItem
import com.binar.chapter8recyclerview.data.GetAllStafResponseItem
import javax.inject.Inject

class NewsRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getNews() : List<GetAllNewsResponseItem>{
        return apiService.getAllNews()
    }
    suspend fun getStafs() : List<GetAllStafResponseItem>{
        return apiService.getAllStaf()
    }
}