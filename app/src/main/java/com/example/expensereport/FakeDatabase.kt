package com.example.expensereport

class FakeDatabase {

    companion object {
        // use by -> FakeDatabase.getSavedCategories()
        fun getSavedCategories(): List<Category> {
            return arrayListOf(
                Category("Groceries"),
                Category("Bills"),
                Category("Miscellaneous")
            )
        }
    }
}