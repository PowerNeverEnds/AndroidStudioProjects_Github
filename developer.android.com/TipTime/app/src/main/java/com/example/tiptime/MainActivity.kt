package com.example.tiptime

import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.example.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        print("2")
        binding.calculateButton.setOnClickListener { println("1"); calculateTip() }
        binding.costOfServiceEditText.setOnKeyListener { view, keyCode, _ ->  handleKeyEvent(view,keyCode)}

    }

    private fun calculateTip() {
        val stringInTextField = binding.costOfServiceEditText.text.toString()
        val cost = stringInTextField.toDoubleOrNull()
        if (cost == null || cost == 0.0) {
            displayTip(0.0)
//            binding.tipResult.text = ""
            return
        }
        val tipPercentage = when (binding.tipOptions.checkedRadioButtonId) {
            R.id.option_twenty_percent -> 0.20
            R.id.option_eighteen_percent -> 0.18
            else -> 0.15
        }
        var tip = tipPercentage * cost
        if (binding.roundUpSwitch.isChecked) {
            tip = kotlin.math.ceil(tip)
        }
        displayTip(tip)
//        println(stringInTextField)
//        println(cost)
//        val a = R.string.tip_amount
//        val b = R.string.amazing_service
//        println("${a} ${b}")
//        println(getString(R.string.tip_amount))
//        println(getString(R.string.tip_amount, formattedTip))
//        println(getString(R.string.tip_amount, "abc"))
//        println(R.string.tip_amount)
//        println(formattedTip)
//        println(binding.tipResult.text)
    }

    private fun displayTip(tip:Double) {
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipResult.text = getString(R.string.tip_amount, formattedTip)

    }

    private fun handleKeyEvent(view: View, keyCode: Int): Boolean {
        if(keyCode == KeyEvent.KEYCODE_ENTER) {
            // Hide the keyboard
            val inputMethodManager =
                getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
//            val inputMethodManager1=
//                getSystemService(INPUT_METHOD_SERVICE)
//            println(inputMethodManager)
//            println(inputMethodManager1)
//            println(inputMethodManager is InputMethodManager)
//            println(inputMethodManager1 is Any)
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
//            inputMethodManager1.hideSoftInputFromWindow(view.windowToken,0)
            return true
        }
        return false
    }

}