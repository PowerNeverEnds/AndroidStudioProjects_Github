package com.example.fragmentoptionmenutest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.appbar.MaterialToolbar

class DrawerLayout: Fragment() {
    private var Fragment: FrameLayout? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Fragment = inflater.inflate(R.layout.activity_main_content, container, false) as FrameLayout?
        setHasOptionsMenu(true)
        return Fragment
    }

}