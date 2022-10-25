package com.example.expensereport

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.expensereport.Database.CategoryDatabase
import com.example.expensereport.Database.entities.CategoryEntity

class CategoriesActivity : AppCompatActivity() {
    private lateinit var categoriesRecycler: RecyclerView
    //private val categoryRepo = CategoriesRepo()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)
        categoriesRecycler = findViewById(R.id.category_recycler)
        //categoryRepo.categoryList.addAll(FakeDatabase.getSavedCategories())
       // val adaptor = CategoryAdaptor(categoryRepo.categoryList)
       // categoriesRecycler.adapter = adaptor
       // testDatabase()
        val repository = CategoriesRepo(this)

    }

    fun testDatabase () {
        val repository = CategoriesRepo(this)
        var category = Category(title = "Billtest")
        category.addExpense(expenseItem = ExpenseItem(description = "Expense1", amount = 2.01))
        category.addExpense(expenseItem = ExpenseItem(description = "Expense2", amount = 4.25))
        repository.addCategory(category)
        repository.addExpenseToCategory(categoryTitle = "Billtest", expenseAmount = 2.01, expenseDescription = "Expense1")
        repository.addExpenseToCategory(categoryTitle = "Billtest", expenseAmount = 4.25, expenseDescription = "Expense2")
        var category2 = Category(title = "Billtest2")
        var category3 = Category(title = "Billtest3")
        var category4 = Category(title = "Billtest4")


        repository.addCategory(category2)
        repository.addCategory(category3)
        repository.addCategory(category4)
    }

}