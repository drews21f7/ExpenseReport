package com.example.expensereport

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.expensereport.Database.CategoryDatabase
import com.example.expensereport.Database.entities.CategoryEntity

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
        testDatabase()
    }

    fun testDatabase () {
        var database = CategoryDatabase.getDatabase(this)
        var category = CategoryEntity(title = "Billtest", totalPrice = 10.01)
        var category2 = CategoryEntity(title = "Billtest2", totalPrice = 10.02)
        var category3 = CategoryEntity(title = "Billtest3", totalPrice = 10.03)
        var category4 = CategoryEntity(title = "Billtest4", totalPrice = 10.04)

        database.categoryDao().insert(category)
        database.categoryDao().insert(category2)
        database.categoryDao().insert(category3)
        database.categoryDao().insert(category4)
    }

}