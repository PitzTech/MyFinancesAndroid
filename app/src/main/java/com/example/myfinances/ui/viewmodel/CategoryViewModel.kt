package com.example.myfinances.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.myfinances.data.database.DatabaseProvider
import com.example.myfinances.data.model.Category
import com.example.myfinances.data.repository.CategoryRepository

class CategoryViewModel(application: Application) : AndroidViewModel(application) {
    private val categoryRepository: CategoryRepository

    init {
        val categoryDao = DatabaseProvider.getDatabase(application).categoryDao()
        categoryRepository = CategoryRepository(categoryDao)
    }

    fun getCategoryById(id: Int): LiveData<Category> = categoryRepository.getCategoryById(id)
    fun getAllCategories(): LiveData<List<Category>> = categoryRepository.getAllCategories()
    fun insert(category: Category) = categoryRepository.insert(category)
    fun update(category: Category) = categoryRepository.update(category)
    fun delete(category: Category) = categoryRepository.delete(category)
}
