package com.task.zoondia.network

sealed class ApiState<out T> {
    data object Idle : ApiState<Nothing>()
    data object Loading : ApiState<Nothing>()
    data class Success<T>(val data: T) : ApiState<T>()
    data class Error(val message: String) : ApiState<Nothing>()
}