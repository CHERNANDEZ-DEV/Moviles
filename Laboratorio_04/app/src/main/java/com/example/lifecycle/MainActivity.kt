package com.example.lifecycle

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var name:TextInputEditText
    private  lateinit var e_mail:TextInputEditText
    private lateinit var number:TextInputEditText

    private lateinit var save: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        save = findViewById(R.id.saveButton)

        name  = findViewById<TextInputEditText>(R.id.nameEditText)
        e_mail = findViewById<TextInputEditText>(R.id.emailEditText)
        number = findViewById<TextInputEditText>(R.id.numberEditText)


        save.setOnClickListener{

            var n = name.text.toString()
            var e = e_mail.text.toString()
            var nu = number.text.toString()

            val intent = Intent(this, secondActivity::class.java)
            intent.putExtra("key_name", n)
            intent.putExtra("key_email", e)
            intent.putExtra("key_number", nu)
            startActivity(intent)
        }
    }
}