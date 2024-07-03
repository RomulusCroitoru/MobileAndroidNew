package com.devmobile.mobilenewproject.models.db

import androidx.room.Embedded
import androidx.room.Relation


//clasa de lagatura
data class CategoryWithProductsDBModel (

     @Embedded val category: ProductCategoryDBModel,
    @Relation(
        parentColumn = ProductCategoryDBModel.ARG_NAME,
        entityColumn = ProductDBModel.ARG_CATEGORY_NAME
    )
    val products: List<ProductDBModel>
    )
