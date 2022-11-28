package com.axis.book.model

import com.axis.book.exception.BookValidations

data class Book (
    var bookID:String,
    var title:String,
    var author:String,
    var category:String,
    var price:Double
    )
