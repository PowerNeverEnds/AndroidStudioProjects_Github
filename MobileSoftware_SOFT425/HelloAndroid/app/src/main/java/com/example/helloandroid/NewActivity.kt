package com.example.helloandroid

import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.ButtonBarLayout

class NewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.newactivity)

 //       val Button: startBtn = findViewById(R.id.startBtn);

        val backBtn = findViewById<View>(R.id.backBtn);

//        val startBtn = findViewById<android.view.View>(R.id.startBtn) as Button
        backBtn.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v: View?) {
                Toast.makeText(applicationContext, "돌아가기 버튼이 눌렸어요.", Toast.LENGTH_LONG).show()
                finish()
            }
        })

    }
}