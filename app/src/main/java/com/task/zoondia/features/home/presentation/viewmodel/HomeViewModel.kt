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

    private val _homeResponse = MutableStateFlow<List<ResponseHome>>(emptyList())
    val homeResponse: StateFlow<List<ResponseHome>> = _homeResponse

    private val _tempResponse = MutableStateFlow<List<ResponseHome>>(emptyList())


    fun fetchProductList() {
        viewModelScope.launch {

            try {

                homeUseCase.fetchProductList().collect { state ->
                    _apiState.value = state

                    if (state is ApiState.Success) {
                        _homeResponse.value = state.data
                        _tempResponse.value = state.data
                    }
                }

            } catch (e: Exception) {
                _apiState.value = ApiState.Error(e.message ?: "An error occurred")
            }
        }

    }

    fun filterList(query: String) {
        _homeResponse.value = if (query.isEmpty()) {
            _tempResponse.value
        } else {
            _tempResponse.value.filter { it.title.contains(query, ignoreCase = true) }
        }
    }
}