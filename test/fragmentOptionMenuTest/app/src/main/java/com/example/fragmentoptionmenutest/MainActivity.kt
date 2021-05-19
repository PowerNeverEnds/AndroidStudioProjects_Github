package com.example.fragmentoptionmenutest

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.FragmentManager
import com.google.android.material.appbar.MaterialToolbar
import androidx.drawerlayout.widget.DrawerLayout

class MainActivity : AppCompatActivity() {
    private val fragmentManager: FragmentManager = supportFragmentManager
    private val fragmentA: FragmentA = FragmentA()
    private val fragmentB: FragmentB = FragmentB()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: MaterialToolbar = findViewById(R.id.topAppBar)
        setSupportActionBar(toolbar)

//        val transaction = fragmentManager.beginTransaction()
//        transaction.replace(R.id.frameLayout, fragmentA).commitAllowingStateLoss()

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


        // navigatoinView

            val mDrawerLayout: DrawerLayout? = findViewById(R.id.drawer_layout)

            // TopAppBar
            val topAppBar: MaterialToolbar? = findViewById<MaterialToolbar>(R.id.topAppBar)
            topAppBar!!.setNavigationOnClickListener {
                Toast.makeText(this.applicationContext, "topAppBar Navigation", Toast.LENGTH_SHORT)
                    .show()
                if (mDrawerLayout!!.isDrawerOpen(GravityCompat.START)) {
                    mDrawerLayout!!.closeDrawer(GravityCompat.START)
                } else
                    mDrawerLayout!!.openDrawer(GravityCompat.START)
            }

    }

}