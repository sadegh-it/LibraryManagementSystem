package main.service

import main.model.Book
import main.repository.LibraryRepository
import main.repository.OperationResult
import main.util.printBooks

object BookService {
    fun addBookFlow() {
        println("📌 عنوان کتاب:")
        val title = readlnOrNull()?.trim().orEmpty()

        println("✍️ نام نویسنده:")
        val author = readlnOrNull()?.trim().orEmpty()

        println("📅 سال انتشار:")
        val year = readlnOrNull()?.toIntOrNull() ?: run {
            println("❌ سال انتشار نامعتبر است.")
            return
        }

        println("🔢 شماره شابک:")
        val isbn = readlnOrNull()?.trim().orEmpty()

        val book = Book(title, author, year, isbn)
        when (val result = LibraryRepository.addBook(book)) {
            is OperationResult.Success -> println(result.message)
            is OperationResult.Failure -> println(result.error)
        }
    }

    fun removeBookFlow() {
        println("🔢 شابک کتابی که می‌خواهید حذف کنید:")
        val isbn = readlnOrNull()?.trim().orEmpty()
        when (val result = LibraryRepository.removeBook(isbn)) {
            is OperationResult.Success -> println(result.message)
            is OperationResult.Failure -> println(result.error)
        }
    }

    fun searchByTitleFlow() {
        println("🔍 عنوان مورد جستجو:")
        val title = readlnOrNull()?.trim().orEmpty()
        val results = LibraryRepository.searchByTitle(title)
        if (results.isEmpty()) {
            println("❌ کتابی با این عنوان پیدا نشد.")
        } else {
            results.printBooks()
        }
    }

    fun searchByAuthorFlow() {
        println("🔍 نام نویسنده مورد جستجو:")
        val author = readlnOrNull()?.trim().orEmpty()
        val results = LibraryRepository.searchByAuthor(author)
        if (results.isEmpty()) {
            println("❌ کتابی با این نویسنده پیدا نشد.")
        } else {
            results.printBooks()
        }
    }
}