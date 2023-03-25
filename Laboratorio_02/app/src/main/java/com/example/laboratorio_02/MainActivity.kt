package com.example.laboratorio_02

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var actionSentButton:Button
    private lateinit var height:EditText
    private lateinit var weight:EditText
    private lateinit var result:TextView
    var result1:Float = 0.0F;
    private lateinit var clasification:TextView


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        actionSentButton = findViewById(R.id.action_calculate_button)
        height = findViewById(R.id.height_edit_text)
        weight = findViewById(R.id.weight_edit_text)
        result = findViewById(R.id.result_text_view)
        var clasification = findViewById<TextView>(R.id.Clasification)



        actionSentButton.setOnClickListener(){

            var w = weight.text.toString()
            var h = height.text.toString()

            if (validateInput(w, h)){
                result1 = calculateBMI(w.toFloat(),h.toFloat())
            }

            result.text = result1.toString()

            when{
                result1 < 18.5 -> {
                    clasification.text = "UnderWeight"
                }
                result1 in 18.5..24.99 ->{
                    clasification.text = "Healthy"
                }
            }

        }
    }

    private fun calculateBMI(weight:Float, height:Float):Float{
        return (weight / (height/100) * (height/100))
    }

    private fun validateInput(weight:String?, height:String?):Boolean{
        return when {
            weight.isNullOrEmpty() -> {
                Toast.makeText(this, "weight is empty", Toast.LENGTH_SHORT).show()
                return false;
            }
            height.isNullOrEmpty()->{
                Toast.makeText(this,"height is empty", Toast.LENGTH_SHORT).show()
                return false
            }
            else->true
        }
    }
}