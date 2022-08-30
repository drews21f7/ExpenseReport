package com.example.expensereport

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class CategoriesActivity : AppCompatActivity() {
    private lateinit var categoriesRecycler: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val categoryInput = intent.getStringExtra("categoryInput")
        println(categoryInput)
        setContentView(R.layout.activity_categories)
        categoriesRecycler = findViewById(R.id.category_recycler)
        var adaptor = CategoryAdaptor(arrayListOf("a", "b", "c", "d", "e"))
        categoriesRecycler.adapter = adaptor
    }

}