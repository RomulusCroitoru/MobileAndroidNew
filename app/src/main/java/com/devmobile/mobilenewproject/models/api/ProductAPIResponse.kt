package com.devmobile.mobilenewproject.models.api

import com.google.gson.annotations.SerializedName

data class ProductAPIResponse (

    val id: Int,
    @SerializedName("title")
    val name: String,
    val category: String,
    val description: String

)
