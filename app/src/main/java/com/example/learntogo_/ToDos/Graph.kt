package com.example.learntogo_.ToDos

import android.content.Context
import com.example.learntogo_.ToDos.Data.TodoDataSource
import hoods.com.todoapp.data.room.TodoDatabase

object Graph {
    lateinit var database: TodoDatabase
        private set
    val todoRepo by lazy {
        TodoDataSource(database.todoDao())
    }

    fun provide(context: Context) {
        database = TodoDatabase.getDatabase(context)
    }
}