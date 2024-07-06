package com.devmobile.mobilenewproject.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.devmobile.mobilenewproject.data.dao.ProductCategoryDAO
import com.devmobile.mobilenewproject.data.dao.ProductDAO
import com.devmobile.mobilenewproject.models.db.ProductCategoryDBModel
import com.devmobile.mobilenewproject.models.db.ProductDBModel

@Database(entities = [
    ProductDBModel::class,
    ProductCategoryDBModel::class
                     ], version = 2)

// Creaza Data Base model
abstract class AppDatabase : RoomDatabase() {

    abstract val productDao: ProductDAO
    abstract val productCategoryDao: ProductCategoryDAO
}