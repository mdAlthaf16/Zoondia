package com.task.zoondia.features.home.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class ResponseHome(
    @SerialName("id") val id: Int = 0,
    @SerialName("title") val title: String = "",
    @SerialName("price") val price: Float = 0f,
    @SerialName("description") val description: String = "",
    @SerialName("category") val category : String = "",
    @SerialName("image") val image: String = "",
    @SerialName("rating") val rating : Rating? = null

)

@Serializable
data class Rating(
    @SerialName("rate") val rate: Float = 0f,
    @SerialName("count") val count: Int = 0
)
