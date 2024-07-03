package com.devmobile.mobilenewproject.data.tasks.product

import android.os.AsyncTask
import com.devmobile.mobilenewproject.ApplicationController
import com.devmobile.mobilenewproject.models.db.ProductCategoryDBModel
import com.devmobile.mobilenewproject.models.db.ProductDBModel

class InsertProductTask(
    val product: ProductDBModel,
    val category: ProductCategoryDBModel,
    val onFinish:() -> Unit
): AsyncTask<Unit, Unit, Unit> (){
    @Deprecated("Deprecated in Java")
    override fun doInBackground(vararg params: Unit) {

        ApplicationController.instance.appDatabase.productDao.insert(product)
        ApplicationController.instance.appDatabase.productCategoryDao.insert(category)
    }

    @Deprecated("Deprecated in Java")
    override fun onPostExecute(result: Unit?) {
        super.onPostExecute(result)

        onFinish.invoke()
    }

}