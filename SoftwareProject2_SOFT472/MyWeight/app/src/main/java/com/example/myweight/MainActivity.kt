package com.example.myweight

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView


class MainActivity :AppCompatActivity(){
    private val fragmentManager: FragmentManager = supportFragmentManager
//    private var transaction: FragmentTransaction = fragmentManager.beginTransaction()
    private val fragmentButton: ButtonFragment = ButtonFragment()
    private val fragmentCard: CardFragment = CardFragment()
    private val fragmentAdd: AddFragment = AddFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    private fun initView(){
        val mDrawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        // navigatoinView

        val navigationView: NavigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener { menuItem ->
            mDrawerLayout.closeDrawer(GravityCompat.START)
            when(menuItem.itemId) {
                R.id.item1 -> {
                    Toast.makeText(this.applicationContext, "item1",Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.item2 -> {
                    Toast.makeText(this.applicationContext, "item2",Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.item3 -> {
                    Toast.makeText(this.applicationContext, "item3",Toast.LENGTH_SHORT).show()
                    true
                }
                else->false
            }
        }

        // TopAppBar
        val topAppBar = findViewById<MaterialToolbar>(R.id.topAppBar)
        topAppBar.setNavigationOnClickListener {
            Toast.makeText(this.applicationContext, "topAppBar Navigation", Toast.LENGTH_SHORT).show()
            if(mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
                mDrawerLayout.closeDrawer(GravityCompat.START)
            }
            else
                mDrawerLayout.openDrawer(GravityCompat.START)
        }
        topAppBar.setOnMenuItemClickListener { menuItem ->
            when(menuItem.itemId) {
                R.id.favorite -> {
                    Toast.makeText(this.applicationContext, "favorite",Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.search -> {
                    Toast.makeText(this.applicationContext, "search",Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.more -> {
                    Toast.makeText(this.applicationContext, "more",Toast.LENGTH_SHORT).show()
                    true
                }

                else -> false
            }
        }

        // BottomNavigationView
        val tv:TextView = findViewById<TextView>(R.id.textView)
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigation.setOnNavigationItemReselectedListener {  }
        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            val transaction = fragmentManager.beginTransaction()
             when(item.itemId) {
                R.id.page_1 -> {
                    // Respond to navigation item 1 click
                    println("page_1")
//                    Toast.makeText(this.applicationContext, "Al", Toast.LENGTH_SHORT).show()
//                    startActivity(Intent(this, MainActivity::class.java))
                    transaction.replace(R.id.frameLayout, fragmentButton).commitAllowingStateLoss()

                    tv.setText("Medium!")
                    true
                }
                R.id.page_2 -> {
                    // Respond to navigation item 2 click
                    println("page_2")
//                    startActivity(Intent(this, MainActivity::class.java))
                    transaction.replace(R.id.frameLayout, fragmentCard).commitAllowingStateLoss()
                    tv.setText("Wasd!")

                    true
                }
                 R.id.page_3 -> {
                    transaction.replace(R.id.frameLayout, fragmentAdd).commitAllowingStateLoss()
                     tv.setText("Android!")
                     true
                 }
                 R.id.page_4 -> {
                     tv.setText("excersize!")
                     true
                 }
                 R.id.page_5 -> {
                     tv.setText("partner!")
                     true
                 }
                else -> {

//                    startActivity(Intent(this, MainActivity::class.java))
                    false
                }
            }
//            true
        }
    }

}