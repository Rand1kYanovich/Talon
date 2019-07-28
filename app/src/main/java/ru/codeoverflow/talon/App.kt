package ru.codeoverflow.talon

import android.app.Application
import android.content.Context
import com.google.firebase.FirebaseApp


class App : Application() {


    companion object {
        private lateinit var instance: App
        private fun getApplication(): App =instance
        fun getContext():Context = getApplication().applicationContext
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

    }





}