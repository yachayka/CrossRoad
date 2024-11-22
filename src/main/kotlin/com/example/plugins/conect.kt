// Определение пакета, в котором находится данный код
package com.example.plugins

// Импортирование необходимых классов для работы с SQL
import java.sql.* // Импорт всех классов из пакета java.sql для работы с базами данных
import java.util.* // Импорт всех классов из пакета java.util, в частности, для работы с коллекциями
import kotlin.collections.ArrayList // Импорт конкретного класса ArrayList из Kotlin

// Определение объекта MySQL, который будет содержать методы и свойства для работы с базой данных
object MySQL {
    // Переменная для хранения соединения с базой данных, инициализированная как null
    var conn: Connection? = null

    // Приватные переменные для хранения данных пользователя и пароля для доступа к базе данных
    private var username = "root"
    private var password = ""

    // Переменная для выполнения SQL-запросов
    var stmt: Statement? = null

    // Переменная для хранения результата выполнения SQL-запросов
    private var resultSet: ResultSet? = null

    // Функция для выполнения подключения к базе данных
    fun getConnection() {
        // Создание объекта Properties для хранения свойств подключения
        val connectionProps = Properties()

        // Установка имени пользователя и пароля в свойства подключения
        connectionProps["username"] = username
        connectionProps["password"] = password

        // Блок try для обработки возможных исключений при подключении
        try {
            // Попытка установить соединение с базой данных MySQL
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/article", connectionProps)
        } catch (e: SQLException) {
            // Обработка исключения, если возникла ошибка SQL, вывод трассировки стека
            e.printStackTrace()
        } catch (e: Exception) {
            /*Обработка других исключений, вывод трассировки стека*/
            e.printStackTrace()
        }
    }
}
