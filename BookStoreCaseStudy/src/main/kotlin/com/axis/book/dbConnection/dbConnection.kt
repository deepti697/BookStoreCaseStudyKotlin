package com.axis.book.dbConnection

import java.sql.Connection
import java.sql.DriverManager

class dbConnection {

        fun connect(): Connection
        {
            val myurl ="jdbc:mysql://localhost:3306/bookstoredb"//localhost is the database name
            val connection= DriverManager.getConnection(myurl,"root","Deepti@9987$")
            return connection
        }

}