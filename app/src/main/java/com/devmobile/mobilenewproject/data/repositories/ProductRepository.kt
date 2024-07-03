package com.devmobile.mobilenewproject.data.repositories

import com.devmobile.mobilenewproject.data.tasks.product.GetCategoryWithProductsTask
import com.devmobile.mobilenewproject.data.tasks.product.InsertProductTask
import com.devmobile.mobilenewproject.models.api.ProductAPIResponseModel
import com.devmobile.mobilenewproject.models.db.CategoryWithProductsDBModel
import com.devmobile.mobilenewproject.models.db.ProductCategoryDBModel
import com.devmobile.mobilenewproject.models.db.ProductDBModel

object ProductRepository {


fun insert(model: ProductAPIResponseModel, onFinish: () -> Unit) {
    val product = ProductDBModel(
            id = model.id,
            name = model.name,
            categoryName = model.category,
            description = model.description
        )


    val category = ProductCategoryDBModel(model.category)


    InsertProductTask(
        product = product,
        category = category,
        onFinish = onFinish
    ).execute()

    }

    fun getCategoryWithProducts(onFinish: (List<CategoryWithProductsDBModel>) -> Unit) {
        GetCategoryWithProductsTask(onFinish).execute()
    }


}
