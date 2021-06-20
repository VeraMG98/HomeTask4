package com.example.kotlin1lesson4.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity(private val layout: Int): AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout)
        showDisconnectState()
        setupUi()
        setupLiveData()
    }

    abstract fun setupLiveData() //инициализация всех LiveData

    abstract fun setupUi() //инициализация всех view

    abstract fun showDisconnectState()
}