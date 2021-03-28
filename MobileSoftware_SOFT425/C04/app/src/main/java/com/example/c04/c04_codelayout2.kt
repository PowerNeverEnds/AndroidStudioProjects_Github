package com.example.c04

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity


class c04_codelayout2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.c04_codelayout)
        val MyLinear = findViewById<View>(com.example.c04.R.id.mylinear) as LinearLayout
        MyLinear.orientation = LinearLayout.HORIZONTAL
        val MyBtn:Button = findViewById(com.example.c04.R.id.mybutton)
        MyBtn.setTextSize(40.toFloat())
        val MyEdit = findViewById<View>(com.example.c04.R.id.myedit) as EditText
        MyEdit.setBackgroundColor(-0xff0100) //  연두색
    }
}