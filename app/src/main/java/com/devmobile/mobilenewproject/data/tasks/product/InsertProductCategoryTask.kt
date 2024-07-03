package com.devmobile.mobilenewproject.data.tasks.product

import android.os.AsyncTask
import com.devmobile.mobilenewproject.ApplicationController
import com.devmobile.mobilenewproject.models.db.ProductCategoryDBModel
import com.devmobile.mobilenewproject.models.db.ProductDBModel

class InsertProductCategoryTask(
    val onFinish:() -> Unit
): AsyncTask<ProductCategoryDBModel, Unit, Unit> (){
    @Deprecated("Deprecated in Java")
    override fun doInBackground(vararg params: ProductCategoryDBModel?) {
        params.getOrNull(0)?.let {productCategory ->
            ApplicationController.instance.appDatabase.productCategoryDao.insert(productCategory)
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onPostExecute(result: Unit?) {
        super.onPostExecute(result)

        onFinish.invoke()
    }

}