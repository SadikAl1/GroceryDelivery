package com.anythum.grocerydelivery.ui
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anythum.grocerydelivery.R
import com.anythum.grocerydelivery.adapter.CategoryAdapter
import com.anythum.grocerydelivery.adapter.ProductAdapter
import com.anythum.grocerydelivery.model.Category
import com.anythum.grocerydelivery.model.Product

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_home)

        // CATEGORY RECYCLERVIEW

        val rvCategories =
            findViewById<RecyclerView>(R.id.rvCategories)

        val categoryList = listOf(

            Category("Fruits", R.drawable.fruits),

            Category("Dairy", R.drawable.daery),

            Category("Snacks", R.drawable.snaks),

            Category("Drinks", R.drawable.drinks)
        )

        val categoryAdapter = CategoryAdapter(categoryList)

        rvCategories.layoutManager =
            LinearLayoutManager(
                this,
                LinearLayoutManager.HORIZONTAL,
                false
            )

        rvCategories.adapter = categoryAdapter

        // PRODUCT RECYCLERVIEW

        val rvProducts =
            findViewById<RecyclerView>(R.id.rvProducts)

        val productList = listOf(

            Product("Apple", 120, R.drawable.apple),

            Product("Milk", 60, R.drawable.milk),

            Product("Bread", 40, R.drawable.bread),

            Product("Tomato", 30, R.drawable.tomato),

            Product("Banana", 50, R.drawable.banana),

            Product("Mango", 100, R.drawable.mango)
        )

        val productAdapter = ProductAdapter(productList)

        rvProducts.layoutManager =
            GridLayoutManager(this, 2)

        rvProducts.adapter = productAdapter

        val btnCart =
            findViewById<Button>(R.id.btnCart)

        btnCart.setOnClickListener {

            startActivity(
                Intent(this, CartActivity::class.java)
            )
        }
    }
}