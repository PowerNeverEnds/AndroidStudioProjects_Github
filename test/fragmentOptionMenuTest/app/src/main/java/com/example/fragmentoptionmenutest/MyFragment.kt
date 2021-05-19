package com.example.fragmentoptionmenutest

import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView

open class MyFragment:Fragment() {
    fun setDefault(){
        setDefaultNavigationMenu()
        setDefaultDrawerLayout()
    }
    fun setDefaultNavigationMenu(){
        val navigationView: NavigationView = activity!!.findViewById<NavigationView>(R.id.nav_view)
        navigationView.menu.clear()
        navigationView.inflateMenu(R.menu.navigation_drawer)
    }
    fun setDefaultDrawerLayout(){
        val mDrawerLayout: DrawerLayout? = getActivity()!!.findViewById(R.id.drawer_layout)
        // TopAppBar
        val topAppBar: MaterialToolbar? = getActivity()!!.findViewById<MaterialToolbar>(R.id.topAppBar)
        topAppBar!!.setNavigationOnClickListener {
            Toast.makeText(activity, "topAppBar Navigation Default", Toast.LENGTH_SHORT).show()
            if (mDrawerLayout!!.isDrawerOpen(GravityCompat.START)) {
                mDrawerLayout!!.closeDrawer(GravityCompat.START)
            } else
                mDrawerLayout!!.openDrawer(GravityCompat.START)
        }
    }
}