package com.task.zoondia.features.home.domain.usecase

import com.task.zoondia.features.home.domain.model.ResponseHome
import com.task.zoondia.features.home.domain.repository.HomeRepository
import com.task.zoondia.network.ApiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class HomeUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) {

    fun fetchProductList(): Flow<ApiState<List<ResponseHome>>> = flow {

        emit(ApiState.Loading)

        try {
            val result = homeRepository.fetchProductList()

            if (result.isSuccessful) {

                val data = result.body()

                if (data != null) {
                    emit(ApiState.Success(data))
                } else {
                    emit(ApiState.Error("Server returns the empty data"))
                }

            } else {
                emit(ApiState.Error(result.message() ?: "An error occurred"))
            }

        } catch (e: Exception) {
            println("error --> $e")
            emit(ApiState.Error(e.message ?: "An error occurred"))
        }

    }
}