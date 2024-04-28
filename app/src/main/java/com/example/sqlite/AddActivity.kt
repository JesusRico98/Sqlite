package com.example.sqlite

import android.content.ContentValues
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_add)

    }

    fun btnAdd(view: View){
        val editTextTitulo: EditText = findViewById(R.id.editTextTextTitulo)
        val editTextDescripcion: EditText = findViewById(R.id.editTextTextDescripcion)

        val baseDatos = DBManager(this)

        val values = ContentValues()
            values.put("Titulo",editTextTitulo.text.toString())
            values.put("Descripcion",editTextDescripcion.text.toString())

        val ID = baseDatos.insert(values)

            if (ID>0){
                Toast.makeText(this,"El registro  se ingreso con exito",Toast.LENGTH_LONG).show()
                finish()
            }else{
                Toast.makeText(this,"El registro no se realizo!",Toast.LENGTH_LONG).show()
            }

    }
}