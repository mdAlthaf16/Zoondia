package com.task.zoondia.network

import com.task.zoondia.features.home.domain.model.ResponseHome
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(ApiConstants.product)
    suspend fun fetchProductList(): Response<List<ResponseHome>>
}