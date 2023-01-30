package com.example.learntogo_

import android.app.Application
import com.example.learntogo_.ToDos.Graph

class TodoApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Graph.provide(this)
    }
}