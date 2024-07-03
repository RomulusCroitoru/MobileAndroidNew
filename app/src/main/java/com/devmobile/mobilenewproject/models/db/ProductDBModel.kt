package com.devmobile.mobilenewproject.models.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "products")
data class ProductDBModel (

    @PrimaryKey
    @ColumnInfo(name = ARG_ID)
    val id: Int,
    @ColumnInfo(name = "title")
    val name: String,
    @ColumnInfo(name = ARG_CATEGORY_NAME)
    val categoryName : String,
    val description: String

)
{
    companion object{
        const val ARG_ID = "id"
        const val ARG_CATEGORY_NAME = "categoryName"
    }
}
