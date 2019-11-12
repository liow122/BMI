package com.example.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonCalculate.setOnClickListener{
            calculate()
        }
        buttonReset.setOnClickListener{
            reset()
        }
    }
    fun calculate() {
        val weight: Float = editWeight.text.toString().toFloat()
        val height: Float = editHeight.text.toString().toFloat()
        val bmi: Float = weight / (height / 100).pow(2)

        if (bmi < 18.5) {
            textViewBMI.text =
                String.format("%s %.2f %s", getString(R.string.bmi), bmi, getString(R.string.under))
            imageView.setImageResource(R.drawable.under)
        } else if (bmi > 18.5 && bmi < 25) {
            textViewBMI.text =
                String.format("%s %.2f %s", getString(R.string.bmi), bmi, getString(R.string.normal))
            imageView.setImageResource(R.drawable.normal)
        } else {
            textViewBMI.text =
                String.format("%s %.2f %s", getString(R.string.bmi), bmi, getString(R.string.over))
            imageView.setImageResource(R.drawable.over)
        }
    }
    fun reset() {
        editWeight.text.clear()
        editHeight.text.clear()
        imageView.setImageResource(R.drawable.empty)
        textViewBMI.text = getString(R.string.bmi)

    }
}
