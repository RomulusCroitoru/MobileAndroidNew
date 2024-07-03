package com.devmobile.mobilenewproject.models.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product_category")
data class ProductCategoryDBModel (
    @PrimaryKey
    @ColumnInfo(name = ARG_NAME)
    val name: String

)
{
    companion object{
            const val ARG_NAME = "name"
    }
}