package com.example.expensereport

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class CategoriesActivity : AppCompatActivity() {
    private lateinit var categoriesRecycler: RecyclerView
    private val categoryRepo = CategoriesRepo()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)
        categoriesRecycler = findViewById(R.id.category_recycler)
        categoryRepo.categoryList.addAll(FakeDatabase.getSavedCategories())
        val adaptor = CategoryAdaptor(categoryRepo.categoryList)
        categoriesRecycler.adapter = adaptor
    }

}