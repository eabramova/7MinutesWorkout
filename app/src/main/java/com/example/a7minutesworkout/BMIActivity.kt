package com.example.a7minutesworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.a7minutesworkout.databinding.ActivityBmiBinding
import java.math.BigDecimal
import java.math.RoundingMode

class BMIActivity : AppCompatActivity() {
    private var binding: ActivityBmiBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBmiBinding.inflate(layoutInflater)

        setContentView(binding?.root)

        setSupportActionBar(binding?.toolbarBmiActivity)
        if (supportActionBar != null) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.title = "Calculate BMI"
        }
        binding?.toolbarBmiActivity?.setNavigationOnClickListener {
            onBackPressed()
        }

        binding?.btnCalculateUnits?.setOnClickListener {
            if (validateMetricUnits()) {
                val height: Float = binding?.etMetricUnitHeight?.text.toString().toFloat() / 100
                val weight: Float = binding?.etMetricUnitWeight?.text.toString().toFloat()
                val bmi: Float = (weight / Math.pow(height.toDouble(), 2.0)).toFloat()
                displayBMIResult(bmi)
            } else {
                Toast.makeText(this@BMIActivity, "Please enter valid values.", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    private fun displayBMIResult(bmi: Float) {

        val bmiLable: String
        val bmiDescription: String
        if (bmi.compareTo(15f) <= 0) {
            bmiLable = "Very severily underweight"
            bmiDescription = "OOPS! You need to take better care of yourself! Eat more!"
        } else if (bmi.compareTo(15f) > 0 && bmi.compareTo(16f) <= 0) {
            bmiLable = "Severily underweight"
            bmiDescription = "OOPS! You need to take better care of yourself! Eat more!"
        } else if (bmi.compareTo(16f) > 0 && bmi.compareTo(18.5f) <= 0) {
            bmiLable = "Underweight"
            bmiDescription = "OOPS! You need to take better care of yourself! Eat more!"
        } else if (bmi.compareTo(18.5f) > 0 && bmi.compareTo(25f) <= 0) {
            bmiLable = "Normal"
            bmiDescription = "Congrats! You are in a good shape"
        } else if (bmi.compareTo(25f) > 0 && bmi.compareTo(30f) <= 0) {
            bmiLable = "Overweight"
            bmiDescription = "OOPS! You need to take better care of yourself! Workout more!"
        } else if (bmi.compareTo(30f) > 0 && bmi.compareTo(35f) <= 0) {
            bmiLable = "Obese Class | (Moderately obese)"
            bmiDescription = "OOPS! You need to take better care of yourself! Workout more!"
        } else if (bmi.compareTo(35f) > 0 && bmi.compareTo(40f) <= 0) {
            bmiLable = "Obese Class || (Severely obese)"
            bmiDescription = "OMG! You are in a very dangerous condition! Act now!"
        } else {
            bmiLable = "Obese Class ||| (Very Severely obese)"
            bmiDescription = "OMG! You are in a very dangerous condition! Act now!"
        }
        val bmiValue = BigDecimal(bmi.toDouble()).setScale(2, RoundingMode.HALF_EVEN).toString()
        binding?.llDisplayBMIResult?.visibility = View.VISIBLE
        binding?.tvBMIValue?.text = bmiValue
        binding?.tvBMIStyle?.text = bmiLable
        binding?.tvBMIDescription?.text = bmiDescription


    }

    private fun validateMetricUnits(): Boolean {
        var isValid = true
        if (binding?.etMetricUnitWeight?.text.toString().isEmpty()) {
            isValid = false
        } else if (binding?.etMetricUnitHeight?.text.toString().isEmpty()) {
            isValid = false
        }
        return isValid
    }
}