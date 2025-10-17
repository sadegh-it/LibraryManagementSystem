package main.app

import main.repository.LibraryRepository
import main.service.BookService
import main.util.printBooks

fun startLibraryManagementSystem() {
    while (true) {
        println("\n📚 سیستم مدیریت کتابخانه 📚")
        println("1️⃣ افزودن کتاب")
        println("2️⃣ حذف کتاب")
        println("3️⃣ جستجو بر اساس عنوان")
        println("4️⃣ جستجو بر اساس نویسنده")
        println("5️⃣ نمایش همه کتاب‌ها")
        println("6️⃣ خروج")

        print("⚡ گزینه: ")

        when (readlnOrNull()?.toIntOrNull()) {
            1 -> BookService.addBookFlow()
            2 -> BookService.removeBookFlow()
            3 -> BookService.searchByTitleFlow()
            4 -> BookService.searchByAuthorFlow()
            5 -> LibraryRepository.getAllBooks().printBooks()
            6 -> {
                println("👋 خروج از برنامه...")
                return
            }
            else -> println("❌ گزینه نامعتبر است.")
        }
    }
}
