package com.example.expensereport

class Category (
    var title: String,
    var totalPrice: Double = 0.0,
    var expenseItem: ArrayList<ExpenseItem> = ArrayList()

)

class ExpenseItem (
    var description: String,
    var amount: Double
)