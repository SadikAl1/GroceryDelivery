package com.anythum.grocerydelivery.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.anythum.grocerydelivery.R
import com.anythum.grocerydelivery.model.CartItem
import com.anythum.grocerydelivery.model.Product
import com.anythum.grocerydelivery.utils.CartManager

class ProductAdapter(
    private val list: List<Product>
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {

        val image = view.findViewById<ImageView>(R.id.imgProduct)

        val title = view.findViewById<TextView>(R.id.txtProductName)

        val price = view.findViewById<TextView>(R.id.txtProductPrice)

        val btnAdd = view.findViewById<Button>(R.id.btnAdd)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_product, parent, false)

        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ProductViewHolder,
        position: Int
    ) {

        val product = list[position]

        holder.title.text = product.name

        holder.price.text = "₹${product.price}"

        holder.image.setImageResource(product.image)

        holder.btnAdd.setOnClickListener {

            CartManager.addItem(

                CartItem(
                    product.name,
                    product.price,
                    product.image
                )
            )

            Toast.makeText(
                holder.itemView.context,
                "Added to cart",
                Toast.LENGTH_SHORT
            ).show()
        }

    }

    override fun getItemCount(): Int {

        return list.size
    }
}