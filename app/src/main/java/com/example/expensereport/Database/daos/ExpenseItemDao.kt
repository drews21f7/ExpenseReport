package com.example.expensereport.Database.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.expensereport.Database.entities.ExpenseItemEntity

@Dao
interface ExpenseItemDao {
    @Query("SELECT * FROM ExpenseItemTable")
    fun getAll(): List<ExpenseItemEntity>

    @Query("SELECT * FROM ExpenseItemTable WHERE category_id == :categoryId")
    fun getByCategoryId(categoryId: String): List<ExpenseItemEntity>

    @Insert
    fun insert(expenseItemEntity: ExpenseItemEntity)

    @Delete
    fun delete(expenseItemEntity: ExpenseItemEntity)
}