package com.devmobile.mobilenewproject.models.api

import com.google.gson.annotations.SerializedName


//folosit pt gson
data class ProductAPIResponseModel (

    val id: Int,
    @SerializedName("title")
    val name: String,
    val category: String,
    val description: String

)
