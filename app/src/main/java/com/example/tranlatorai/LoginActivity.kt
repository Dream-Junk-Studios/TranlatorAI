package com.example.tranlatorai

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.text.TextUtils
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.tranlatorai.Retrofit.IMyService
import com.example.tranlatorai.Retrofit.RetrofitClient
import com.google.android.material.datepicker.MaterialStyledDatePickerDialog
import io.reactivex.android.schedulers.AndroidSchedulers

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


import retrofit2.Retrofit


class LoginActivity : AppCompatActivity() {

    private lateinit var iMyService: IMyService
    private var compositeDisposable = CompositeDisposable()

    override fun onStop() {
        compositeDisposable.clear()
        super.onStop()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //Inicializacion de la API

        val retrofit:Retrofit = RetrofitClient.getInstance()
        iMyService = retrofit.create(IMyService::class.java)

        //evento
        val textRegister = findViewById<TextView>(R.id.text_register)
        val loginButton = findViewById<Button>(R.id.btn_login)
        loginButton.setOnClickListener{
            val emailText = findViewById<EditText>(R.id.email_text)
            val passwordText = findViewById<EditText>(R.id.password_text)
            loginUser(emailText.text.toString(), passwordText.text.toString())
        }
        textRegister.setOnClickListener() {
            val signupIntent = Intent(this, LoginActivity::class.java)
            startActivity(signupIntent)

        }
    }

    private fun loginUser(email: String, password: String) {
        if(TextUtils.isEmpty(email))
        {
            Toast.makeText(this@LoginActivity,"Email cant be empty",Toast.LENGTH_SHORT).show()
            return;
        }
        if(TextUtils.isEmpty(password))
        {
            Toast.makeText(this@LoginActivity,"Password cant be empty",Toast.LENGTH_SHORT).show()
            return;
        }

        compositeDisposable.add(iMyService.loginUser(email,password)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {result ->
                Toast.makeText(this@LoginActivity,""+result,Toast.LENGTH_SHORT).show()

            })
    }
}



