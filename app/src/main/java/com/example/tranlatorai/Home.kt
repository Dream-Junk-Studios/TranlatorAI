package com.example.tranlatorai

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.python.util.PythonInterpreter

class Home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val translateButton = findViewById<Button>(R.id.translateButton);
        val textToTranslate = findViewById<EditText>(R.id.textToTranslate)
        val translatedText  = findViewById<TextView>(R.id.translatedText)
        val python = PythonInterpreter()
        python.exec("import parr from parr")
        python.exec("resultado = parr.paraphrase_text(" + textToTranslate.text.toString() + ")")
        val resultado = python.get("resultado").asString()
        translatedText.text = resultado;


    }
}