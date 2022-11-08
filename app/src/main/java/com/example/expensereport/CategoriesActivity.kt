package com.example.expensereport

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.expensereport.Database.CategoryDatabase
import com.example.expensereport.Database.entities.CategoryEntity

class CategoriesActivity : AppCompatActivity() {
    private lateinit var cancelButton: ImageView
    private lateinit var checkBox: ImageView
    private lateinit var categoryText: EditText

    private lateinit var categoriesRecycler: RecyclerView
    private val categoryRepo = CategoriesRepo(this)
    private val categoryAdaptor = CategoryAdaptor(categories = categoryRepo.getAllCategories())

    private val clickListener = object: CategoryAdaptor.ClickListener{
        override fun delete(categoryTitle: String) {
            categoryRepo.deleteCategory(title = categoryTitle)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        categoryAdaptor.clickListener = clickListener
        setContentView(R.layout.activity_categories)

        cancelButton = findViewById(R.id.cancel_button)
        checkBox = findViewById(R.id.check)
        categoryText = findViewById(R.id.category_text)



        categoriesRecycler = findViewById(R.id.category_recycler)
        categoriesRecycler.adapter = categoryAdaptor
        setClickListener()
    }

    fun setClickListener() {
        cancelButton.setOnClickListener { categoryText.text.clear() }
        checkBox.setOnClickListener {
            val input = categoryText.text.toString()
            if (input.isEmpty()) {
                Toast.makeText(this, "Enter Category!", Toast.LENGTH_LONG).show()
            } else if (categoryRepo.categoryExists(input)) {
                Toast.makeText(this, "Category already exists", Toast.LENGTH_LONG).show()
            } else {
                categoryRepo.addCategory(title = input)
                Toast.makeText(this, "Category Created", Toast.LENGTH_LONG).show()
                categoryAdaptor.notifyDataSetChanged()
            }
        }
    }
}