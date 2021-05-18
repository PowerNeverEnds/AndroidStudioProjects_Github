package com.example.fragmentoptionmenutest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {
    private val fragmentManager: FragmentManager = supportFragmentManager
    private val fragmentA: FragmentA = FragmentA()
    private val fragmentB: FragmentB = FragmentB()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout, fragmentA).commitAllowingStateLoss()

        val btn:Button=findViewById(R.id.button)
        btn.setOnClickListener({
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.frameLayout, fragmentA).commitAllowingStateLoss()
        })
        val btn2:Button=findViewById(R.id.button2)
        btn2.setOnClickListener({
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.frameLayout, fragmentB).commitAllowingStateLoss()
        })
    }
}