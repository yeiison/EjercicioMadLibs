package com.example.mad_libs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_palabras.*
import java.util.*
import kotlin.random.Random

class Palabra : AppCompatActivity() {

    var dir = 0
    val posicion = 123
    var total1 = 0
    var total2 = 0
    val lista = ArrayList<String>()
    val palabras = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_palabras)

        modificar("madlib_universidad")

    }
    fun modificar(leer: String){
        val buscar = StringBuilder()
        this.dir = resources.getIdentifier(leer, "raw", packageName)
        val scan = Scanner(resources.openRawResource(dir))
        while(scan.hasNextLine()){
            val line = scan.nextLine()
            buscar.append(line)
        }
        var alltext = buscar.toString()
        val reg = Regex("<.*?>")
        val found = reg.findAll(alltext)
        found.forEach{ x ->
            val y = x.value
            palabras.add(y)
            total2++
        }
        total1 = total2
        val valor = palabras.get(0)
        edt1.hint = "$valor"
    }

    fun Conteo(texto3: View){
        if(edt1.text.toString().isEmpty() || edt1.text.toString().trim().isEmpty()){
            Toast.makeText(applicationContext, "Digite una palabra", Toast.LENGTH_SHORT).show()
        }
        else{
            val word = edt1.text.toString().trim()
            lista.add(word)
            total2--
            edt1.setText("")
            if(total2 >= 1){
                val total = palabras.get(palabras.size - total2)
                edt1.hint = " $total "
            }else if(total2 == 0){
                val intent = Intent(this, Historia::class.java)
                intent.putExtra("dato", lista)
                startActivityForResult(intent, posicion)
            }
        }
    }
    fun ran(): Int{
        val numero : Int = Random.nextInt(1,1000)
        Toast.makeText(applicationContext, numero.toString(), Toast.LENGTH_LONG).show()
        return numero
    }

}
