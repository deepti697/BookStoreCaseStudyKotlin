package com.axis.book.app
import com.axis.book.model.Book
import com.axis.book.service.bookstoreService
import com.axis.book.exception.BookValidations
import com.axis.book.exception.InvalidBookException
import java.util.*


fun main() {
    var sc = Scanner(System.`in`)
    var bookService = bookstoreService()
    var validateDetails =BookValidations()
    //to store data of 3 books in database
  /*  for (book in 1.. 3) {
    print("Enter Book ID: ")
    var bookID: String = sc.next()
        print("Enter Book Title : ")
    var title: String = sc.next()
        title+=sc.nextLine()
    print("Enter Book Author : ")
    var author: String = sc.next()
        author+=sc.nextLine()
    print("Enter Book Category : ")
    var category: String = sc.next()
    print("Enter Book price : ")
    var price: Double = sc.nextDouble()

    var book = Book(bookID, title, author, category, price)
    bookService.addBook(book)
}*/
    while(true){
        println("===============MENU=================")
        println(" 1.Add Book \n 2.Modify Book Details \n 3.Delete Book \n 4.Display All Books \n 5.Display Specific Book \n 6.Search Book by Title \n 7.Search Book by Author \n 8.Sort Book By Price")
        print("Enter your choice : ")
        var choice=sc.nextInt()
        sc.nextLine()

        when(choice){

            1->{
                print("Enter Book ID : ")
                var bookID=sc.nextLine()
                try {
                    validateDetails.validateBookId(bookID)
                }catch(e:InvalidBookException){
                    println(e.message)
                }
                print("Enter Book title :")
                var title=sc.nextLine()
                print("Enter Book author : ")
                var author=sc.nextLine()
                print("Enter Book category : ")
                var category=sc.nextLine()
                try {
                    validateDetails.validateCategory(category)
                }catch(e:InvalidBookException){
                    println(e.message)
                }
                print("Enter Book price : ")
                var price=sc.nextDouble()
                try {
                    validateDetails.validatePrice(price)
                }catch(e:InvalidBookException){
                    println(e.message)
                }

                var book=Book(bookID,title,author,category,price)
                var result=bookService.addBook(book)
                /*if(result) {
                    bookService.addBook(book)
                }
                else{
                    println("Validations Failed!!!!!")
                }*/

            }

            2->{
                print("Enter Book Id to modify : ")
                var id=sc.nextLine()
                print("Enter Column name to edit : ")
                var column=sc.nextLine()
                print("Enter Value to update : ")
                var value=sc.nextLine()

                bookService.modifyBook(id,column,value)
            }

            3->{
                print("Enter BookID to delete : ")
                var id=sc.nextLine()
                bookService.deleteBook(id)
            }

            4->{
                bookService.displayAll()
            }

            5->{
                print("Enter BookID to display : ")
                var id=sc.nextLine()
                bookService.displaySpecificBook(id)
            }

            6->{
                print("Enter Book title to search : ")
                var title=sc.nextLine()
                bookService.searchByTitle(title)
            }

            7->{
                print("Enter Book author to search : ")
                var author=sc.nextLine()
                bookService.searchByAuthor(author)
            }
            8->{
                bookService.sortByPrice()
            }

            else->{
                println("Enter correct choice!!!!!!!!")
                break
            }
        }

    }
}


