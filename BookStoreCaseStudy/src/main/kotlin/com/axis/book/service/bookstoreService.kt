package com.axis.book.service
import com.axis.book.model.Book
import com.axis.book.utility.bookstoreUtil
class bookstoreService {

    var bookUtil =bookstoreUtil()

    fun addBook(book: Book){
       var result= bookUtil.addBook(book)
//        if(result>0){
//            println("Book added Successfully!!!!!!!")
//        }
//        else{
//            println("Book insertion Failed!!!!")
//        }
    }

    fun modifyBook(id:String,column:String,value:String){
        var result=bookUtil.modifyBook(id,column,value)
        println(result)
    }

    fun deleteBook(id:String){
        var result=bookUtil.deleteBook(id)
        if(result)
            println("Book Deleted Successfully!!!!!")
        else
            println("deletion failed")
    }

    fun displayAll(){
        var books=bookUtil.displayAll()
        println("=================Details of all Books in BookStore=============")
        for(book in books){
            println(book)
        }
    }

    fun displaySpecificBook(id:String)
    {
        var books=bookUtil.displaySpecificBook(id)
        println("===================Specific Book Details =======================")
        for(book in books){
            println(book)
        }
    }

    fun searchByTitle(title:String){
        var books=bookUtil.searchByTitle(title)
        println("==================Book Details searched by title====================")
        for(book in books){
            println(book)
        }
    }

    fun searchByAuthor(author:String){
        var books=bookUtil.searchByAuthor(author)
        println("=================Book Details searched by author=====================")
        for(book in books){
            println(book)
        }
    }

    fun sortByPrice(){
        var books=bookUtil.sortByPrice()
        println("====================Book Details sorted by Price=======================")
        for(book in books){
            println(book)
        }
    }

}

