package com.bookwishlist.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bookwishlist.domain.Book
import com.bookwishlist.repo.InMemoryRepository

class BookViewModel constructor(private val repository: InMemoryRepository)  : ViewModel() {

    val movieList = MutableLiveData<List<Book>>()

    fun getAllBooks() {
        movieList.postValue(repository.getAllBooks())
    }
}