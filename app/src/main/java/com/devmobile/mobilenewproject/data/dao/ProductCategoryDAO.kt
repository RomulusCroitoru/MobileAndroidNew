package com.devmobile.mobilenewproject.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.devmobile.mobilenewproject.models.CategoryModel
import com.devmobile.mobilenewproject.models.db.CategoryWithProductsDBModel
import com.devmobile.mobilenewproject.models.db.ProductCategoryDBModel
@Dao
interface ProductCategoryDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(model: ProductCategoryDBModel)

    @Query("SELECT * FROM product_category")
    fun getAllWithProducts(): List<CategoryWithProductsDBModel>
}