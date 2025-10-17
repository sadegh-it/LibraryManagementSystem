package main.util

import main.model.Book

fun List<Book>.printBooks() {
    if (this.isEmpty()) {
        println("هیچ کتابی در لیست موجود نیست.")
        return
    }

    this.forEachIndexed { index, book ->
        println("\n📖 کتاب ${index + 1}:")
        println("عنوان: ${book.title}")
        println("نویسنده: ${book.author}")
        println("سال انتشار: ${book.publicationYear}")
        println("شابک: ${book.isbn}")
    }
}