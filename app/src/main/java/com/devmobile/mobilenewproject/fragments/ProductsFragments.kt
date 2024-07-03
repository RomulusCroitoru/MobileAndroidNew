package com.devmobile.mobilenewproject.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.devmobile.mobilenewproject.R
import com.devmobile.mobilenewproject.adapters.CartItemListAdapter
import com.devmobile.mobilenewproject.data.repositories.ProductRepository
import com.devmobile.mobilenewproject.models.CartItemModel
import com.devmobile.mobilenewproject.models.CategoryModel
import com.devmobile.mobilenewproject.models.ProductModel
import com.devmobile.mobilenewproject.models.api.ProductAPIResponseModel
import com.devmobile.mobilenewproject.models.db.ProductDBModel
import com.devmobile.mobilenewproject.utils.extensions.VolleyRequestQueue
import com.devmobile.mobilenewproject.utils.extensions.logErrorMessage
import com.devmobile.mobilenewproject.utils.extensions.showToast
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ProductsFragments : Fragment() {

    private val cartItemList by lazy {
         ArrayList<CartItemModel>()
    }
    private val adapter by lazy {
        CartItemListAdapter(cartItemList)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_products,container,false)

// se va creea view ul fragmentului
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        getProducts()
    }
    private fun setupRecyclerView() {

        val layoutManager = LinearLayoutManager(context)

        //cautam id-ul rv_products si le vom afisa din fragment ProductsFragment
        view?.findViewById<RecyclerView>(R.id.rv_products)?.apply {
            this.layoutManager = layoutManager
            this.adapter = this@ProductsFragments.adapter
        }

    }

    @SuppressLint("SuspiciousIndentation")
    private  fun getProducts()
    {

        val url = "https://fakestoreapi.com/products"

        // Request a string response from the provided URL. (apelare api si callback pt raps/eroare)
        val stringRequest = StringRequest(
        Request.Method.GET, url,
        { response ->
            // Display the first 500 characters of the response string.
            //"Response".logErrorMessage()
            handleProductsResponse(response)
        },
        {
            "That didn't work!".logErrorMessage()
        })

            // Add the request to the RequestQueue.
            //folosesc coada noastra
            VolleyRequestQueue.addToRequestQueue(stringRequest)

    }

    private fun handleProductsResponse(response: String) {

        //deserializare json in lista de produse
        val type = object : TypeToken<List<ProductAPIResponseModel>>() {}.type
        val responseJsonArray = Gson().fromJson<List<ProductAPIResponseModel>>(response, type)

        responseJsonArray.getOrNull(0)?.let { responseProduct ->
            insertProductToDB(responseProduct)

        }

        //din lista de produse vreau sa extrag liste de categorii
            responseJsonArray
            .groupBy { it.category }
            .forEach {
                val categoryModel = CategoryModel(
                    name = it.key,
                    description = it.key,
                )

                val products = it.value.map { productApi ->
                    ProductModel(
                        name = productApi.name,
                        description = productApi.description,
                    )
                }

                cartItemList.add(categoryModel)
                cartItemList.addAll(products)


            }

        adapter.notifyItemRangeInserted(0, cartItemList.size)
    }

    private fun insertProductToDB(productModel: ProductAPIResponseModel) {
        ProductRepository.insert(productModel){
            "Product successfully added to DB".showToast(context)
        }
    }

}