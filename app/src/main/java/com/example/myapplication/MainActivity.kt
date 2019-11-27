package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_Calculate.setOnClickListener {

            val weight:Double = weight.text.toString().toDouble()
            val height:Double = height.text.toString().toDouble()

            val bmi = calculateBMI(height,weight)
            val status:String

            if(bmi<18.5) {
              status = "Under"
                imageView.setImageResource(R.drawable.under)
            }
            else if(bmi>=18.5 && bmi <=24.9){
                status = "Normal"
                imageView.setImageResource(R.drawable.normal)
                }
            else {
                status = "Over"
                imageView.setImageResource(R.drawable.over)
            }

            BMI.text = "%.2f".format(bmi, status)



        }
        btn_Reset.setOnClickListener {
            imageView.setImageResource(R.drawable.empty)

            BMI.text = null
            weight.text = null
            height.text = null

            weight.requestFocus()
        }
    }


    public fun calculateBMI(height:Double,weight:Double):Double {

        return weight /(height * height)
    }
}
