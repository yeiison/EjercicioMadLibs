package com.example.mad_libs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_bienvenida.*

class Bienvenida : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bienvenida)

        btnEmpezar.setOnClickListener { _ -> empezar() }
    }

    fun empezar() {
        val palabras = Intent(this, Palabra::class.java)
        startActivity(palabras)
    }
}