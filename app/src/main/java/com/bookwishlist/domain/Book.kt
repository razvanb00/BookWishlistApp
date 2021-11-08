package com.bookwishlist.domain

import java.io.FileDescriptor

data class Book(
    val id: Number,
    var name: String,
    var author: String,
    var description: String,
    var format: FormatEnum,
)
