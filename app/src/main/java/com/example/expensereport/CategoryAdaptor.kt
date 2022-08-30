package com.example.expensereport

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CategoryAdaptor(private val categories: ArrayList<String>): RecyclerView.Adapter<CategoryAdaptor.ViewHolder>() {


    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var categoryTitle: TextView


        init {
            categoryTitle = view.findViewById(R.id.category_title)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.categoryTitle.text = categories[position]
    }

    override fun getItemCount(): Int {
        return categories.size
    }
}