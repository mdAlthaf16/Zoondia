package com.task.zoondia.features.home.presentation.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.task.zoondia.features.home.presentation.components.ProductListItemView
import com.task.zoondia.features.home.presentation.components.SearchView
import com.task.zoondia.features.home.presentation.components.ShimmerHome
import com.task.zoondia.features.home.presentation.viewmodel.HomeViewModel
import com.task.zoondia.navigation.Destinations
import com.task.zoondia.navigation.LocalNavController
import com.task.zoondia.network.ApiState

@Composable
fun HomeScreen() {


    val navController = LocalNavController.current
    val context = LocalContext.current

    val viewModel: HomeViewModel = hiltViewModel()
    val apiState by viewModel.apiState.collectAsStateWithLifecycle()
    val homeResponse by viewModel.homeResponse.collectAsState()

    var searchQuery by rememberSaveable { mutableStateOf("") }

    LaunchedEffect(Unit) {
        if (apiState !is ApiState.Success) {
            viewModel.fetchProductList()
        }
    }

    when (val state = apiState) {


        is ApiState.Error -> {
            Toast.makeText(context, state.message, Toast.LENGTH_SHORT).show()
        }

        else -> Unit
    }


    if (apiState is ApiState.Loading) {
        ShimmerHome()
    }

    if (apiState is ApiState.Success) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .systemBarsPadding()
        ) {

            SearchView(
                query = searchQuery,
                onValueChange = { query ->
                    searchQuery = query
                    viewModel.filterList(query)

                }
            )
            Spacer(Modifier.height(20.dp))

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),

                ) {

                itemsIndexed(homeResponse) { _, item ->
                    ProductListItemView(item = item, onClick = { clickedItem ->
                        navController.navigate(
                            Destinations.NavDetailScreen(
                                title = clickedItem.title,
                                image = clickedItem.image,
                                price = clickedItem.price,
                                category = clickedItem.category,
                                rating = clickedItem.rating?.rate ?: 0f,
                                totalRating = clickedItem.rating?.count ?: 0,
                                description = clickedItem.description
                            )
                        )
                    })
                }

            }
        }
    }

}