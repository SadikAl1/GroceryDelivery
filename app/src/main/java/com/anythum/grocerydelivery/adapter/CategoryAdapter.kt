package com.anythum.grocerydelivery.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.anythum.grocerydelivery.R
import com.anythum.grocerydelivery.model.Category

class CategoryAdapter(
    private val list: List<Category>
) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    inner class CategoryViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {

        val image = view.findViewById<ImageView>(R.id.imgCategory)

        val title = view.findViewById<TextView>(R.id.txtCategory)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_category, parent, false)

        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: CategoryViewHolder,
        position: Int
    ) {

        val category = list[position]

        holder.title.text = category.name

        holder.image.setImageResource(category.image)
    }

    override fun getItemCount(): Int {

        return list.size
    }
}