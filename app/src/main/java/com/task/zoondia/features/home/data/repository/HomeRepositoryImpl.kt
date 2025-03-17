package com.task.zoondia.features.home.data.repository

import com.task.zoondia.features.home.domain.model.ResponseHome
import com.task.zoondia.features.home.domain.repository.HomeRepository
import com.task.zoondia.network.ApiService
import retrofit2.Response
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : HomeRepository {
    override suspend fun fetchProductList(): Response<List<ResponseHome>> {
        return apiService.fetchProductList()
    }
}