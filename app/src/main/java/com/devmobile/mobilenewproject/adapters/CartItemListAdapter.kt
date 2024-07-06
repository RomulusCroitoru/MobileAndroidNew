package com.devmobile.mobilenewproject.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.devmobile.mobilenewproject.R
import com.devmobile.mobilenewproject.models.CartItemModel
import com.devmobile.mobilenewproject.models.CartItemType
import com.devmobile.mobilenewproject.models.CategoryModel
import com.devmobile.mobilenewproject.models.ProductModel
import com.devmobile.mobilenewproject.utils.extensions.logErrorMessage

class CartItemListAdapter(
    private val cartItemList: List<CartItemModel>
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun getItemCount() = cartItemList.size


    //suprascriem metoda getItemViewTipe si preluam key-ul din enum
    // facem diferenta intre celula de product si celula de category
    override fun getItemViewType(position: Int) = cartItemList[position].type.key

    //scroll create viewholder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        //obtinem contextul in care se gaseste parintele (parent)
        val inflater = LayoutInflater.from(parent.context)

        //in functie de key-ul obtinut de getItemViewType ia view-ul corespunzator
        //pentru product model

       return when( viewType){
            CartItemType.PRODUCT.key -> {
                "onCreateViewHolder --> PRODUCT".logErrorMessage("ProductListAdapter")

                val view = inflater.inflate(R.layout.item_product, parent, false)
                ProductViewHolder(view)

            }

            CartItemType.PRODUCT_CATEGORY.key -> {
                "onCreateViewHolder --> CATEGORY".logErrorMessage("ProductListAdapter")

                val view = inflater.inflate(R.layout.item_product_category, parent, false)
                 ProductCategoryViewHolder(view)

            }
            else -> super.createViewHolder(parent, viewType)

       }

    }


    //dam valoare view urilor din viewHolder
    //cu obiecte de tip Product model cu apelativul it prin elvis metod
    // obtinem modelul din lista de produse
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val model = cartItemList.getOrNull(position) ?: return

        when(holder){
            is ProductViewHolder -> (model as? ProductModel)?.let { holder.bind(it) }

            is ProductCategoryViewHolder -> (model as? CategoryModel)?.let { holder.bind(it) }

        }

    }

    //celula de product cu obiecte de product
    //se ocupa de asignarea valorilor pt fiecare view in parte si pt fiecare item din lista
    inner class ProductViewHolder (private val view: View): RecyclerView.ViewHolder(view) {


        val productNameTextView : TextView
        val productDescriptionTextView : TextView


        //initializam view urii
        init{
            productNameTextView = view.findViewById(R.id.tv_product_name)
            productDescriptionTextView = view.findViewById(R.id.tv_product_description)

        }
        //dam valoare view urilor
        fun bind(model: ProductModel) {
            productNameTextView.text = model.name
            productDescriptionTextView.text = model.description

        }
    }

    //celula de category cu obiecte de category
    inner class ProductCategoryViewHolder (private val view: View): RecyclerView.ViewHolder(view) {


        val categoryNameTextView : TextView
        val categoryDescriptionTextView : TextView


        //initializam view urii
        init{
            categoryNameTextView = view.findViewById(R.id.tv_product_category_name)
            categoryDescriptionTextView = view.findViewById(R.id.tv_product_category_description)

        }
        //dam valoare view urilor
        fun bind(model: CategoryModel) {
            categoryNameTextView.text = model.name
            categoryDescriptionTextView.text = model.description

        }
    }

}
