package com.binar.chapter8recyclerview.api

import com.binar.chapter8recyclerview.data.GetAllNewsResponseItem
import com.binar.chapter8recyclerview.data.GetAllStafResponseItem
import retrofit2.http.GET

interface ApiService {
    @GET("news")
    suspend fun getAllNews() : List<GetAllNewsResponseItem>

    @GET("staf")
    suspend fun getAllStaf() : List<GetAllStafResponseItem>
}