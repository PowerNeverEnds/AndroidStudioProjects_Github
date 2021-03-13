package com.example.helloandroid

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.ButtonBarLayout

class HelloAndroidActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello_android)

 //       val Button: startBtn = findViewById(R.id.startBtn);

        val startBtn = findViewById<View>(R.id.startBtn);

//        val startBtn = findViewById<android.view.View>(R.id.startBtn) as Button
        startBtn.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v: View?) {
                Toast.makeText(applicationContext, "시작 버튼이 눌렸어요.", Toast.LENGTH_LONG).show()
            }
        })

    }
}