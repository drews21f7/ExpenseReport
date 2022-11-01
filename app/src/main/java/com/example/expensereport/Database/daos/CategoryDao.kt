package com.example.expensereport.Database.daos

import android.icu.text.CaseMap
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.expensereport.Database.entities.CategoryEntity

@Dao
interface CategoryDao {
    @Query("SELECT * FROM CategoryTable")
    fun getAll(): List<CategoryEntity>



    @Insert
    fun insert(categoryEntity: CategoryEntity)

    @Query("DELETE * FROM CategoryTable WHERE title == :categoryTitle")
    fun delete(categoryTitle: String)
}