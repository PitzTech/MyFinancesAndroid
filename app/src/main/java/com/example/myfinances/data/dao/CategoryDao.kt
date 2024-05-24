package com.example.myfinances.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.myfinances.data.model.Category

@Dao
interface CategoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(category: Category)

    @Update
    fun update(category: Category)

    @Delete
    fun delete(category: Category)

    @Query("SELECT * FROM categories WHERE id = :id")
    fun getCategoryById(id: Int): LiveData<Category>

    @Query("SELECT * FROM categories")
    fun getAllCategories(): LiveData<List<Category>>
}
