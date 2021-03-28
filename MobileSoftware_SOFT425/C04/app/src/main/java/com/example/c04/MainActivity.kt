package com.example.c04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startBtn = findViewById<View>(R.id.btn1);

//        val startBtn = findViewById<android.view.View>(R.id.startBtn) as Button
        startBtn.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v: View?) {
                Toast.makeText(applicationContext, "시작 버튼이 눌렸어요.", Toast.LENGTH_LONG).show()

                val myIntent = Intent(applicationContext,c04_table::class.java);
                startActivity(myIntent);
            }
        })

        val start02Btn = findViewById<View>(R.id.btn2);

//        val startBtn = findViewById<android.view.View>(R.id.startBtn) as Button
        start02Btn.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v: View?) {
                Toast.makeText(applicationContext, "시작 버튼이 눌렸어요.", Toast.LENGTH_LONG).show()

                val myIntent = Intent(applicationContext,c04_codelayout2::class.java);
                startActivity(myIntent);
            }
        })

    }
}