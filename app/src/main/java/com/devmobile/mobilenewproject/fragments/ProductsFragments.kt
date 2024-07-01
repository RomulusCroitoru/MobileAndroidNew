package com.devmobile.mobilenewproject.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.devmobile.mobilenewproject.R
import com.devmobile.mobilenewproject.adapters.ProductListAdapter
import com.devmobile.mobilenewproject.models.CategoryModel
import com.devmobile.mobilenewproject.models.ProductModel

class ProductsFragments : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_products,container,false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
    }
    private fun setupRecyclerView() {

        val layoutManager = LinearLayoutManager(context)

        //array de elemente category si product
        val productList = listOf(

            CategoryModel(
                name = "Category name 1",
                description = "Category description 1"
            ),
            ProductModel(
                name = "Product name 1",
                description = "Product description 1"
            ),
            ProductModel(
                name = "Product name 2",
                description = "Product description 2"
            ),
            ProductModel(
                name = "Product name 3",
                description = "Product description 3"
            ),
            CategoryModel(
                name = "Category name 2",
                description = "Category description 2"
            ),
            ProductModel(
                name = "Product name 4",
                description = "Product description 4"
            ),
            ProductModel(
                name = "Product name 5",
                description = "Product description 5"
            ),
            CategoryModel(
                name = "Category name 3",
                description = "Category description 3"
            ),
            ProductModel(
                name = "Product name 6",
                description = "Product description 6"
            ),
            CategoryModel(
                name = "Category name 4",
                description = "Category description 4"
            ),
            ProductModel(
                name = "Product name 7",
                description = "Product description 7"
            ),
            ProductModel(
                name = "Product name 8",
                description = "Product description 8"
            ),
            CategoryModel(
                name = "Category name 5",
                description = "Category description 5"
            ),
            ProductModel(
                name = "Product name 9",
                description = "Product description 9"
            ),
            ProductModel(
                name = "Product name 10",
                description = "Product description 10"
            ),
        )

        val adapter = ProductListAdapter(productList)

        //cautam id-ul rv_products
        view?.findViewById<RecyclerView>(R.id.rv_products)?.apply {
            this.layoutManager = layoutManager
            this.adapter = adapter
        }

    }


    }