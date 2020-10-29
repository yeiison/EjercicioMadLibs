package com.example.mad_libs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import kotlinx.android.synthetic.main.activity_historia.*
import java.util.*
import kotlin.collections.ArrayList

class Historia : AppCompatActivity() {
    val generate: String = "madlib_universidad"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historia)
        val inputs = intent.getStringArrayListExtra("dato")

        if (inputs != null) {
            storyfin(inputs, resources.getIdentifier(generate, "raw", packageName))
        }

        btnIniciarHistoria.setOnClickListener { _ -> iniciarHistaria() }

    }

    fun storyfin(inputs: ArrayList<String>, idir: Int){
        val builder = StringBuilder()
        val scan = Scanner(resources.openRawResource(idir))
        val L = scan.nextLine()
        builder.append(L)

        while(scan.hasNextLine()){
            val line = scan.nextLine()
            builder.append(" ")
            builder.append(line)
        }

        var `val` = builder.toString()
        val reg = Regex("<.*?>")
        val blanco = reg.findAll(`val`).map { it.value }
        var i: Int = 0
        for(blanco in blanco){
            `val` = `val`.replaceFirst(blanco, inputs.get(i))
            i++
        }
        texto5.text = "$`val`"
    }

    fun iniciarHistaria (){
        val bienvenid = Intent(this, Bienvenida::class.java)
        startActivity(bienvenid)
    }

}