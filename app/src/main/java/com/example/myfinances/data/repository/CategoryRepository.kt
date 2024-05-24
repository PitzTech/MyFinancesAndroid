package com.example.myfinances.data.repository

import androidx.lifecycle.LiveData
import com.example.myfinances.data.dao.CategoryDao
import com.example.myfinances.data.model.Category

class CategoryRepository(private val categoryDao: CategoryDao) {
    fun getCategoryById(id: Int): LiveData<Category> = categoryDao.getCategoryById(id)
    fun getAllCategories(): LiveData<List<Category>> = categoryDao.getAllCategories()
    fun insert(category: Category) = categoryDao.insert(category)
    fun update(category: Category) = categoryDao.update(category)
    fun delete(category: Category) = categoryDao.delete(category)
}
