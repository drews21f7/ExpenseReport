package com.example.expensereport

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CategoryAdaptor(private val categories: ArrayList<Category>): RecyclerView.Adapter<CategoryAdaptor.ViewHolder>() {


    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var categoryTitle: TextView
        var historyButton: ImageView
        var expenseDescription: EditText
        var expenseAmount: EditText
        var cancelButton: Button
        var saveButton: Button
        var categoryTotal: TextView


        init {
            categoryTitle = view.findViewById(R.id.category_title)
            historyButton = view.findViewById(R.id.img_history)
            expenseDescription = view.findViewById(R.id.expense_description)
            expenseAmount = view.findViewById(R.id.expense_amount)
            cancelButton = view.findViewById(R.id.cancel_button)
            saveButton = view.findViewById(R.id.save_button)
            categoryTotal = view.findViewById(R.id.category_total_amount)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = categories[position]
        holder.categoryTitle.text = category.title
        holder.categoryTotal.text = category.formatExpenseTotals()
        holder.saveButton.setOnClickListener{
            val description = holder.expenseDescription.text.toString()
            val amount = holder.expenseAmount.text.toString().toDouble()
            val categoryExpense = ExpenseItem(description = description, amount = amount)
            category.addExpense(categoryExpense)
            holder.categoryTotal.text = category.formatExpenseTotals()
        }
    }

    override fun getItemCount(): Int {
        return categories.size
    }
}