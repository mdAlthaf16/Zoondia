package com.task.zoondia.features.home.domain.repository

import com.task.zoondia.features.home.domain.model.ResponseHome
import retrofit2.Response

interface HomeRepository {

    suspend fun fetchProductList(): Response<List<ResponseHome>>
}