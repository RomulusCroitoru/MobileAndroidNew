package com.devmobile.mobilenewproject.models

//modelul celulei din lista
data class ProductModel (
    val name: String,
    val description: String
) : CartItemModel(
    type = CartItemType.PRODUCT
)
