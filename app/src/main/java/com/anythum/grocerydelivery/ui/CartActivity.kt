package com.anythum.grocerydelivery.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anythum.grocerydelivery.R
import com.anythum.grocerydelivery.adapter.CartAdapter
import com.anythum.grocerydelivery.utils.CartManager

class CartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_cart)

        val rvCart =
            findViewById<RecyclerView>(R.id.rvCart)

        val txtTotal =
            findViewById<TextView>(R.id.txtTotal)

        val btnCheckout =
            findViewById<Button>(R.id.btnCheckout)

        btnCheckout.setOnClickListener {

            startActivity(
                Intent(this, CheckoutActivity::class.java)
            )
        }

        fun updateTotal() {

            val total =
                CartManager.cartItems.sumOf {

                    it.price * it.quantity
                }

            txtTotal.text = "Total: ₹$total"
        }

        val adapter = CartAdapter(
            CartManager.cartItems,
            ::updateTotal
        )

        rvCart.layoutManager =
            LinearLayoutManager(this)

        rvCart.adapter = adapter

        updateTotal()
    }
}