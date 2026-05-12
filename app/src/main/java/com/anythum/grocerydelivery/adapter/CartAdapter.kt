package com.anythum.grocerydelivery.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.anythum.grocerydelivery.R
import com.anythum.grocerydelivery.model.CartItem

class CartAdapter(
    private val list: MutableList<CartItem>,
    private val onQuantityChanged: () -> Unit
) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    inner class CartViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {

        val image = view.findViewById<ImageView>(R.id.imgCart)

        val title = view.findViewById<TextView>(R.id.txtCartName)

        val price = view.findViewById<TextView>(R.id.txtCartPrice)

        val quantity = view.findViewById<TextView>(R.id.txtQuantity)

        val btnPlus = view.findViewById<Button>(R.id.btnPlus)

        val btnMinus = view.findViewById<Button>(R.id.btnMinus)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CartViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_cart_item, parent, false)

        return CartViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: CartViewHolder,
        position: Int
    ) {

        val item = list[position]

        holder.title.text = item.name

        holder.price.text = "₹${item.price}"

        holder.quantity.text = item.quantity.toString()

        holder.image.setImageResource(item.image)

        holder.btnPlus.setOnClickListener {

            item.quantity++

            notifyItemChanged(position)

            onQuantityChanged()
        }

        holder.btnMinus.setOnClickListener {

            if (item.quantity > 1) {

                item.quantity--

                notifyItemChanged(position)

            } else {

                list.removeAt(position)

                notifyItemRemoved(position)
            }

            onQuantityChanged()
        }
    }

    override fun getItemCount(): Int {

        return list.size
    }
}