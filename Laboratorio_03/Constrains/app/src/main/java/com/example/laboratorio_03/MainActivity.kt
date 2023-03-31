package com.example.laboratorio_03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.ImageView


class MainActivity : AppCompatActivity() {

    private lateinit var countFiveCent : ImageView
    private lateinit var countTenCent: ImageView
    private lateinit var countQuarterCent: ImageView
    private lateinit var countOneDollar: ImageView
    private lateinit var updateAccountMoney: TextView
    var currentMoney:Float = 0F

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()

        currentMoney = updateAccountMoney.text.toString().toFloat()

        listeners()

    }

    fun listeners (){
        countFiveCent.setOnClickListener(){
            currentMoney += 0.05F
            "%.2f".format(currentMoney).toFloat()
            updateAccountMoney.text = currentMoney.toString()
        }

        countTenCent.setOnClickListener(){
            currentMoney += 0.10F
            "%.2f".format(currentMoney).toFloat()
            updateAccountMoney.text = currentMoney.toString()
        }

        countQuarterCent.setOnClickListener(){
            currentMoney += 0.25F
            "%.2f".format(currentMoney).toFloat()
            updateAccountMoney.text = currentMoney.toString()
        }

        countOneDollar.setOnClickListener(){
            currentMoney += 1F
            "%.2f".format(currentMoney).toFloat()
            updateAccountMoney.text = currentMoney.toString()
        }
    }
    fun bind(){
        countFiveCent = findViewById(R.id.fiveCentsImageView)
        countTenCent = findViewById(R.id.tenCentsImageView)
        countQuarterCent = findViewById(R.id.quarterCentsImageView)
        countOneDollar = findViewById(R.id.oneDollarImageView)
        updateAccountMoney = findViewById(R.id.accountTextView)
    }

}


