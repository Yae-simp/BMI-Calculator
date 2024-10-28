package com.example.bmicalculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.TextViewCompat
import com.google.android.material.slider.Slider
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    lateinit var weightSlider: Slider
    lateinit var heightSlider: Slider
    lateinit var calculateButton: Button
    lateinit var resultTextView: TextView
    lateinit var resultTextViewIndex: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        weightSlider = findViewById(R.id.weightSlider)
        heightSlider = findViewById(R.id.heightSlider)
        calculateButton = findViewById(R.id.calculateButton)
        resultTextView = findViewById(R.id.resultTextView)
        resultTextViewIndex = findViewById(R.id.resultTextViewIndex)

        calculateButton.setOnClickListener() {
            Log.i ("MainActivity", "You pressed Calculate.")
            val height = heightSlider.value
            val weight = weightSlider.value
            val result = weight / (height / 100).pow(2) //pow se utiliza para elevar a un número.
            var resultIndex = ""

            when (result) {
                in 0.0..16.0 -> {
                    setColorAndText(R.color.severeThinness, R.string.severeThinness.toString())
                    resultIndex = "Severe thinness"
                }
                in 16.0 .. 17.0 -> {
                    setColorAndText(R.color.moderateThinness, R.string.moderateThinness.toString())
                    resultIndex = "Moderate thinness"
                }
                in 17.0..18.5 -> {
                    setColorAndText(R.color.mildThinness, R.string.mildThinness.toString())
                    resultIndex = "Mild thinness"
                }
                in 18.5..25.0 -> {
                    setColorAndText(R.color.normalWeight, R.string.normalWeight.toString())
                    resultIndex = "Normal weight"
                }
                in 25.0..30.0 -> {
                    setColorAndText(R.color.overweight, R.string.overweight.toString())
                    resultIndex = "Overweight"
                }
                in 30.0..35.0 -> {
                    setColorAndText(R.color.obeseClassI, R.string.obeseClassI.toString())
                    resultIndex = "Obese Class I"
                }
                in 35.0..40.0 -> {
                    setColorAndText(R.color.obeseClassII, R.string.obeseClassII.toString())
                    resultIndex = "Obese Class II"
                }
                in 40.0..100.0 -> {
                    setColorAndText(R.color.obeseClassIII, R.string.obeseClassIII.toString())
                    resultIndex = "Obese Class III"
                }
        }
            resultTextView.text = "$result"
            Log.i ("MainActivity","Your height is $height and your weight is $weight.")

            resultTextViewIndex.text = resultIndex
            Log.i("MainActivity", resultIndex)
        }
    }
    private fun setColorAndText (colorRes:Int, textRes:String) {
        val color = getColor(colorRes)
        resultTextView.setTextColor(color)
        resultTextViewIndex.setTextColor(color)

    }
}

