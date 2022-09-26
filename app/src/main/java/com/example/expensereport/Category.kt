package com.example.expensereport

import java.text.NumberFormat
import java.util.*
import kotlin.collections.ArrayList

class Category (
    var title: String,
    var totalPrice: Double = 0.0,
    var expenseItems: ArrayList<ExpenseItem> = ArrayList()

){
    fun formatExpenseTotals (): String {
        val format = NumberFormat.getCurrencyInstance()
        format.currency = Currency.getInstance(Locale.US)

        return format.format(totalPrice)
    }
    fun addExpense (expenseItem: ExpenseItem) {
        totalPrice = 0.0
        expenseItems.add(expenseItem)
        for (item in expenseItems) {
            totalPrice += item.amount
        }
    }
}

class ExpenseItem (
    var description: String,
    var amount: Double
)
