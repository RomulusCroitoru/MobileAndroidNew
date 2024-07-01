package com.devmobile.mobilenewproject.models
enum class CartItemType(val key: Int) {
    PRODUCT(0),
    PRODUCT_CATEGORY(1)
}
sealed class CartItemModel (
    val type: CartItemType
)