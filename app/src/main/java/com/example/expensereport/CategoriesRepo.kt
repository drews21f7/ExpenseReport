package com.example.expensereport

import android.content.Context
import com.example.expensereport.Database.CategoryDatabase
import com.example.expensereport.Database.entities.CategoryEntity
import com.example.expensereport.Database.entities.ExpenseItemEntity

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

    fun addExpenseToCategory(
        categoryTitle: String,
        expenseDescription: String,
        expenseAmount: Double
    ) {
        val expenseItem = ExpenseItem(description = expenseDescription, amount = expenseAmount)
        categoryList.forEach{ category ->
            if (category.title == categoryTitle) {
                category.addExpense(expenseItem)
            }
        }

        database.expenseItemDao().insert(
            expenseItemEntity = ExpenseItemEntity(
                categoryId = categoryTitle,
                description = expenseDescription,
                amount = expenseAmount
            )
        )
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