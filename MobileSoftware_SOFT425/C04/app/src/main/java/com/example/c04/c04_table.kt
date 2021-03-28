package com.example.c04

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class c04_table : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.c04_table)

        val loginBtn = findViewById<View>(R.id.loginBtn);

        loginBtn.setOnClickListener(
            object : View.OnClickListener {
                override fun onClick(v: View?) {

                    val idET:EditText = findViewById(R.id.idET);
                    val toastStr = idET.getText().toString() + "님 로그인 되었습니다.";
                    Toast.makeText(applicationContext, toastStr, Toast.LENGTH_LONG).show()

                }
            })
    }
}