package com.anythum.grocerydelivery.ui

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.anythum.grocerydelivery.R
import com.anythum.grocerydelivery.utils.CartManager
import com.google.android.material.button.MaterialButton
import kotlin.jvm.java

class CheckoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_checkout)

        // VIEWS

        val etAddress =
            findViewById<EditText>(R.id.etAddress)

        val rbCash =
            findViewById<RadioButton>(R.id.rbCash)

        val rbOnline =
            findViewById<RadioButton>(R.id.rbOnline)

        val txtItems =
            findViewById<TextView>(R.id.txtItems)

        val txtTotal =
            findViewById<TextView>(R.id.txtTotal)

        val btnPlaceOrder =
            findViewById<MaterialButton>(R.id.btnPlaceOrder)

        // TOTAL CALCULATION

        val itemCount =
            CartManager.cartItems.sumOf { it.quantity }

        val subtotal =
            CartManager.cartItems.sumOf {

                it.price * it.quantity
            }

        val deliveryFee = 40

        val finalTotal = subtotal + deliveryFee

        txtItems.text = "Items: $itemCount"

        txtTotal.text = "Total: ₹$finalTotal"

        // PLACE ORDER

        btnPlaceOrder.setOnClickListener {

            val address =
                etAddress.text.toString().trim()

            // ADDRESS VALIDATION

            if (address.isEmpty()) {

                Toast.makeText(
                    this,
                    "Please enter address",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            // PAYMENT VALIDATION

            if (!rbCash.isChecked && !rbOnline.isChecked) {

                Toast.makeText(
                    this,
                    "Please select payment method",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }



            Toast.makeText(
                this,
                "Order Placed Successfully",
                Toast.LENGTH_LONG
            ).show()

            CartManager.cartItems.clear()

            val intent =
                Intent(this, SuccessActivity::class.java)

            startActivity(intent)

            finish()
        }
    }
}