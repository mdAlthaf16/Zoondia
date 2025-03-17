package com.task.zoondia.features.home.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.task.zoondia.features.home.domain.model.ResponseHome
import com.task.zoondia.features.home.domain.usecase.HomeUseCase
import com.task.zoondia.network.ApiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeUseCase: HomeUseCase
) : ViewModel() {

    private val _apiState = MutableStateFlow<ApiState<List<ResponseHome>>>(ApiState.Idle)
    val apiState: StateFlow<ApiState<List<ResponseHome>>> = _apiState

    fun fetchProductList() {
        viewModelScope.launch {

            try {

                homeUseCase.fetchProductList().collect { state -> _apiState.value = state }
                
            } catch (e: Exception) {
                _apiState.value = ApiState.Error(e.message ?: "An error occurred")
            }
        }

    }

}