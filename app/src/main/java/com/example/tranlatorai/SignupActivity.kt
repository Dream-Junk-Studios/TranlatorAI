package com.example.tranlatorai

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val name = findViewById<EditText>(R.id.nameTextbox)
        val surname = findViewById<EditText>(R.id.surnameTextbox)
        val email = findViewById<EditText>(R.id.emailTextbox)
        val phone = findViewById<EditText>(R.id.phoneTextbox)





    }
}