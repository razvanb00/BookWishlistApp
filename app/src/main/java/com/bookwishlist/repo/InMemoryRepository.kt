package com.bookwishlist.repo

import com.bookwishlist.domain.Book
import com.bookwishlist.domain.FormatEnum

class InMemoryRepository {
    var currId = 10;

    var bookList : MutableList<Book> = ArrayList()

    fun getAllBooks(): MutableList<Book> {
        return bookList;
    }

    init {
        bookList = mutableListOf(
            Book(1,"Amintiri din copilarie", "Ion Creanga", "Carte de povesti pentru copii.", FormatEnum.PHYSICAL),
            Book(2,"Tata bogat,tata sarac", "Robert T. Kiyosaki", "Educatie financiara in familie.", FormatEnum.PHYSICAL),
            Book(3,"Sapiens", "Yuval Noah Harari", "O scurta istorie a umanitatii", FormatEnum.AUDIOBOOK),
            Book(4,"Alta carte 1", "Alt autor 1", "Alta descriere 1", FormatEnum.PHYSICAL),
            Book(5,"Alta carte 2", "Alt autor 2", "Alta descriere 2", FormatEnum.AUDIOBOOK),
            Book(6,"Alta carte 3", "Alt autor 3", "Alta descriere 3", FormatEnum.PDF),
            Book(7,"Alta carte 4", "Alt autor 4", "Alta descriere 4", FormatEnum.PDF),
            Book(8,"Alta carte 5", "Alt autor 5", "Alta descriere 5", FormatEnum.PDF),
            Book(9,"Alta carte 6", "Alt autor 6", "Alta descriere 6", FormatEnum.PHYSICAL),
        )
    }



}