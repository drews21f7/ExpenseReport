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
        val category1 = Category(title = categoryInput!!)
        val categoryRepo = CategoriesRepo()
        categoryRepo.categoryList.add(category1)
        val adaptor = CategoryAdaptor(categoryRepo.categoryList)
        categoriesRecycler.adapter = adaptor
    }

}