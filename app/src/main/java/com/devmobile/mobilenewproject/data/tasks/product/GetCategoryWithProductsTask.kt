package com.devmobile.mobilenewproject.data.tasks.product

import android.os.AsyncTask
import com.devmobile.mobilenewproject.ApplicationController
import com.devmobile.mobilenewproject.models.db.CategoryWithProductsDBModel
import com.devmobile.mobilenewproject.models.db.ProductDBModel

class GetCategoryWithProductsTask(
    val onFinish:(List<CategoryWithProductsDBModel>) -> Unit
): AsyncTask<Unit, Unit, List<CategoryWithProductsDBModel>> (){
    @Deprecated("Deprecated in Java")
    override fun doInBackground(vararg params: Unit?): List<CategoryWithProductsDBModel> {
       return ApplicationController.instance.appDatabase.productCategoryDao.getAllWithProducts()
    }

    @Deprecated("Deprecated in Java")
    override fun onPostExecute(result: List<CategoryWithProductsDBModel>) {
        super.onPostExecute(result)
        onFinish(result)

    }

}