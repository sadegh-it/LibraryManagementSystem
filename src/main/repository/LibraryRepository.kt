package main.repository

import main.model.Book

object LibraryRepository {
    private val books = mutableListOf<Book>()

    fun addBook(book: Book): OperationResult {
        if (books.any { it.isbn == book.isbn }) {
            return OperationResult.Failure("❌ کتابی با این شابک قبلاً ثبت شده است.")
        }
        books.add(book)
        return OperationResult.Success("✅ کتاب با موفقیت اضافه شد.")
    }

    fun removeBook(isbn: String): OperationResult {
        val removed = books.removeIf { it.isbn == isbn }
        return if (removed) {
            OperationResult.Success("✅ کتاب با موفقیت حذف شد.")
        } else {
            OperationResult.Failure("❌ کتابی با این شابک یافت نشد.")
        }
    }

    fun searchByTitle(title: String): List<Book> =
        books.filter { it.title.contains(title, ignoreCase = true) }

    fun searchByAuthor(author: String): List<Book> =
        books.filter { it.author.contains(author, ignoreCase = true) }

    fun getAllBooks(): List<Book> = books
}