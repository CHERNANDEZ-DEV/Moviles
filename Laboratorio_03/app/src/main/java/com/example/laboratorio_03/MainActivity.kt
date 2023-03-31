

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

        listeners()

    }

    fun listeners (){
        countFiveCent.setOnClickListener(){
            currentMoney += 0.05F
            updateAccountMoney.text = "%.2f".format(currentMoney)
        }

        countTenCent.setOnClickListener(){
            currentMoney += 0.10F
            updateAccountMoney.text = "%.2f".format(currentMoney)
        }

        countQuarterCent.setOnClickListener(){
            currentMoney += 0.25F
            updateAccountMoney.text = "%.2f".format(currentMoney)
        }

        countOneDollar.setOnClickListener(){
            currentMoney += 1F
            updateAccountMoney.text = "%.2f".format(currentMoney)
        }
    }
    fun bind(){
        countFiveCent = findViewById(R.id.fiveCentImageView)
        countTenCent = findViewById(R.id.tenCentImageView)
        countQuarterCent = findViewById(R.id.quarterCentImageView)
        countOneDollar = findViewById(R.id.oneDollarImageView)
        updateAccountMoney = findViewById(R.id.accountTextView)
    }

}
