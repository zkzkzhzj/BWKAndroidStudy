package com.example.ch9_resource

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resources.getBoolean(R.bool.test_bool)
        resources.getInteger(R.integer.test_integer)
        resources.getString(R.string.app_name)
    }
}