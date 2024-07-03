package com.devmobile.mobilenewproject.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.devmobile.mobilenewproject.models.db.ProductDBModel

//cerem datele le bagam in baza de date locala si le afisam in recycle view
@Dao
interface ProductDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(product: ProductDBModel)

    @Insert
    fun insertAll(products: List<ProductDBModel>)

    @Query("SELECT * FROM products")
    fun getAll(): List<ProductDBModel>

}