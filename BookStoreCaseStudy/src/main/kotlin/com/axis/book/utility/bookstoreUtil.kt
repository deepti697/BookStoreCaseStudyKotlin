package com.axis.book.utility
import com.axis.book.dbConnection.dbConnection
import com.axis.book.model.Book
class bookstoreUtil {
    var dbConnection= dbConnection()
    var connection=dbConnection.connect()

    var book= mutableListOf<Book>()

    //1.Add Book
    fun addBook(book: Book){

        val addbook=connection.prepareStatement("insert into bookstore values(?,?,?,?,?)")
        addbook.setString(1,book.bookID)
        addbook.setString(2,book.title)
        addbook.setString(3,book.author)
        addbook.setString(4,book.category)
        addbook.setDouble(5,book.price)

        val result = addbook.executeUpdate()

        if (result>0){
            println("Book is Added in Database!!!")
        }
        else{
            println("Book is not added in Database")
        }
    }

    //2.to search book by title
    fun searchByTitle(title:String):MutableList<Book>{
        val prestmt=connection.prepareStatement("select * from bookstore where title=?")
        prestmt.setString(1,title)
        val result=prestmt.executeQuery()
        val books= mutableListOf<Book>()
        while(result.next()){
            val bookId=result.getString("bookID")
            val title=result.getString("title")
            val author=result.getString("author")
            val category=result.getString("category")
            val price=result.getDouble("price")
            books.add(Book(bookId,title,author,category,price))
        }
        return books
    }

    //3.to search book by author
    fun searchByAuthor(author:String):MutableList<Book>{
        val prestmt=connection.prepareStatement("select * from bookstore where author=?")
        prestmt.setString(1,author)
        val result=prestmt.executeQuery()
        val books= mutableListOf<Book>()
        while(result.next()){
            val bookId=result.getString("bookId")
            val title=result.getString("title")
            val author=result.getString("author")
            val category=result.getString("category")
            val price=result.getDouble("price")
            books.add(Book(bookId,title,author,category,price))
        }
        return books
    }

    //4.to display all books
    fun displayAll():MutableList<Book>{
        val prestmt=connection.prepareStatement("select * from bookstore")
        val result=prestmt.executeQuery()
        val books= mutableListOf<Book>()
        while(result.next()){
            val bookId=result.getString("bookId")
            val title=result.getString("title")
            val author=result.getString("author")
            val category=result.getString("category")
            val price=result.getDouble("price")
            books.add(Book(bookId,title,author,category,price))
        }
        return books
    }

    //5.to display specific book
    fun displaySpecificBook(id:String):MutableList<Book>
    {
        val prestmt=connection.prepareStatement("select * from bookstore where bookId=? ")
        prestmt.setString(1,id)
        val result=prestmt.executeQuery()
        val books= mutableListOf<Book>()
        while(result.next()){
            val bookId=result.getString("bookId")
            val title=result.getString("title")
            val author=result.getString("author")
            val category=result.getString("category")
            val price=result.getDouble("price")
            books.add(Book(bookId,title,author,category,price))
        }
        return books
    }

    //6.to delete a book
    fun deleteBook(id:String):Boolean{
        val prestmt=connection.prepareStatement("select * from bookstore where bookId=?")
        prestmt.setString(1,id)
        val result=prestmt.executeQuery()
        var flag=false
        while(result.next()){
            val prestmt1=connection.prepareStatement("delete from bookstore where bookId=?")
            prestmt1.setString(1,id)
            val result1=prestmt1.executeUpdate()
            if(result1>0)
                flag=true
        }
        return flag
    }
    //7.to sort book by price
    fun sortByPrice():MutableList<Book>{
        val prestmt=connection.prepareStatement("select * from bookstore order by price")
        val result=prestmt.executeQuery()
        val books= mutableListOf<Book>()
        while(result.next()){
            val bookId=result.getString("bookId")
            val title=result.getString("title")
            val author=result.getString("author")
            val category=result.getString("category")
            val price=result.getDouble("price")
            books.add(Book(bookId,title,author,category,price))
        }
        return books
    }

    //8.Modify book
    fun modifyBook(id:String,column:String,value:String):String{
        var message=""
        if(column=="title"){
            val prestmt1=connection.prepareStatement("update bookstore set title=? where bookId=?")
            prestmt1.setString(1,value)
            prestmt1.setString(2,id)
            val result1=prestmt1.executeUpdate()
            if(result1>0)
                message="title of book is modified!!!!"

        }
        else if(column=="author"){
            val prestmt1=connection.prepareStatement("update bookstore set author=? where bookId=?")
            prestmt1.setString(1,value)
            prestmt1.setString(2,id)
            val result1=prestmt1.executeUpdate()
            if(result1>0)
                message="author of book is modified!!!!!!!!!!"
        }
        else if(column=="category"){
            val prestmt1=connection.prepareStatement("update bookstore set category=? where bookId=?")
            prestmt1.setString(1,value)
            prestmt1.setString(2,id)
            val result1=prestmt1.executeUpdate()
            if(result1>0)
                message="category of book is modified!!!!!!!"
        }
        else if(column=="price"){
            val prestmt1=connection.prepareStatement("update bookstore set price=? where bookId=?")
            prestmt1.setDouble(1,value.toDouble())
            prestmt1.setString(2, id)
            val result1=prestmt1.executeUpdate()
            if(result1>0)
                message="price of book is modified!!!!!!!!!"
        }
        else{
            message="book not found"
        }
        return message
    }


}
