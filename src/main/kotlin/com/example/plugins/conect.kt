package com.example.plugins


import java.sql.*
import java.util.*
import kotlin.collections.ArrayList

object MySQL{
    var conn: Connection? = null
    private var username = "root"
    private var password = ""
    var stmt: Statement? = null
    private var resultSet: ResultSet? = null

    fun getConnection(){
        val connectionProps = Properties()
        connectionProps["username"] = username
        connectionProps["password"] = password
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/article", connectionProps)

        } catch (e: SQLException) {
            e.printStackTrace()
        } catch (e: Exception){
            e.printStackTrace()
        }
    }
}