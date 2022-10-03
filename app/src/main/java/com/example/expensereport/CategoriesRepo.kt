package com.example.expensereport

import android.content.Context
import com.example.expensereport.Database.CategoryDatabase
import com.example.expensereport.Database.entities.CategoryEntity

class CategoriesRepo(context: Context) {
    private val categoryList: ArrayList<Category> = arrayListOf()
    private val database: CategoryDatabase

    init {
        database = CategoryDatabase.getDatabase(context)
        initializeCategoryList()
    }

    fun addCategory(category: Category) {
        database.categoryDao().insert(category.toEntity())
    }

    fun getAllCategories(): ArrayList<Category> {
        return categoryList
    }

    private fun initializeCategoryList() {
        var categories = database.categoryDao().getAll()
        categories.forEach{
            categoryList.add(it.toCategory())
        }
    }
}

fun Category.toEntity(): CategoryEntity {
    return CategoryEntity(title = title, totalPrice = totalPrice)
}

fun CategoryEntity.toCategory(): Category {
    return Category(title = title, totalPrice = totalPrice)
}