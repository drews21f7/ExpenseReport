package com.example.expensereport.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.expensereport.Database.daos.CategoryDao
import com.example.expensereport.Database.daos.ExpenseItemDao
import com.example.expensereport.Database.entities.CategoryEntity
import com.example.expensereport.Database.entities.ExpenseItemEntity

@Database(entities = [CategoryEntity::class, ExpenseItemEntity::class], version = 1)
abstract class CategoryDatabase:RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
    abstract fun expenseItemDao(): ExpenseItemDao

    companion object {
        private var INSTANCE: CategoryDatabase? = null

        fun getDatabase(context: Context): CategoryDatabase {
            if (INSTANCE == null) {
                synchronized(CategoryDatabase::class.java) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        CategoryDatabase::class.java, "category_database"
                    ).allowMainThreadQueries().build()
                }
            }
            return INSTANCE!!
        }
    }
}