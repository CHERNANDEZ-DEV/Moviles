package com.example.lifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.lifecycle.R.id.showNumberTextView

class secondActivity : AppCompatActivity() {

    private lateinit var nameView:TextView
    private lateinit var emailView:TextView
    private lateinit var numberView:TextView
    private lateinit var share:Button

    private lateinit var n:String
    private  lateinit var e:String
    private  lateinit var nu:String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        nameView = findViewById(R.id.showNameTextView)
        emailView = findViewById(R.id.showEmailTextView)
        numberView = findViewById(R.id.showNumberTextView)

        share = findViewById(R.id.shareButton)

        n = intent.getStringExtra("key_name").toString()
        e = intent.getStringExtra("key_email").toString()
        nu = intent.getStringExtra("key_number").toString()


        nameView.text = n
        emailView.text = e
        numberView.text = nu

        share.setOnClickListener{
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Name: $n \n Email: $e \n Number: $nu")
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)

        }

    }
}