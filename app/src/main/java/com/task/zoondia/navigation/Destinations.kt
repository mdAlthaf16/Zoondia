package com.task.zoondia.navigation

import kotlinx.serialization.Serializable

sealed class Destinations {

    @Serializable
    data object NavHomeScreen : Destinations()


    @Serializable
    data class NavDetailScreen(
        val title : String,
        val image : String,
        val price : Float,
        val category : String,
        val rating : Float,
        val totalRating : Int,
        val description : String,
    ) : Destinations()

}