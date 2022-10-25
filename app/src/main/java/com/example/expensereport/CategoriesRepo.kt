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

    fun addCategory(title: String) {
        val category = Category(title = title)
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

        database.expenseItemDao().insert(expenseItem.toExpenseItemEntity(categoryTitle))
    }

    fun getAllCategories(): ArrayList<Category> {
        return categoryList
    }

    private fun initializeCategoryList() {
        val categories = database.categoryDao().getAll()
        categories.forEach{
            val expenses = database.expenseItemDao().getByCategoryId(categoryId = it.title)
            val category = it.toCategory()

            expenses.forEach{
                category.addExpense(it.toExpenseItem())
            }
            categoryList.add(category)
        }
    }
}

fun Category.toEntity(): CategoryEntity {
    return CategoryEntity(title = title, totalPrice = totalPrice)
}

fun CategoryEntity.toCategory(): Category {
    return Category(title = title, totalPrice = totalPrice)
}

fun ExpenseItemEntity.toExpenseItem(): ExpenseItem {
    return ExpenseItem(description = description, amount = amount)
}

fun ExpenseItem.toExpenseItemEntity(categoryId: String): ExpenseItemEntity {
    return ExpenseItemEntity(description = description, amount = amount, categoryId = categoryId)
}