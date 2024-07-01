package com.devmobile.mobilenewproject.models

data class ProductModel (
    val name: String,
    val description: String
) : CartItemModel(
    type = CartItemType.PRODUCT
)
