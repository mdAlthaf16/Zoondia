package com.task.zoondia.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.task.zoondia.features.details.presentation.screen.DetailScreen
import com.task.zoondia.features.home.presentation.screen.HomeScreen

@Composable
fun SetupNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController, startDestination = Destinations.NavHomeScreen
    ) {

        composable<Destinations.NavHomeScreen> { HomeScreen() }

        composable<Destinations.NavDetailScreen> {
            val itemDetail = it.toRoute<Destinations.NavDetailScreen>()
            DetailScreen(itemDetail)
        }
    }

}