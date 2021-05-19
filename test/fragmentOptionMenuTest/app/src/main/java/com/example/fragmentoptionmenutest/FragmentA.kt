package com.example.fragmentoptionmenutest

import android.os.Bundle
import android.view.*
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView


class FragmentA : MyFragment() {
    private var FragmentA: FrameLayout? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        FragmentA = inflater.inflate(R.layout.fragment_a, container, false) as FrameLayout?
        setHasOptionsMenu(true)
//        val tb: MaterialToolbar = (getActivity() as AppCompatActivity?)!!.findViewById(R.id.topAppBar)
//        tb = view!!.findViewById<View>(R.id.topAppBar) as MaterialToolbar
        val activity = activity as AppCompatActivity?  //  fragmentB 초기화 안할시 activity오류가 발생안할려면 activity선언
//        activity!!.setSupportActionBar(tb)

//
////        val actionBar: ActionBar = activity!!.supportActionBar()
//        val actionBar = activity!!.supportActionBar
////        actionBar!!.setDisplayShowCustomEnabled(true) //커스터마이징 하기 위해 필요
//
//        actionBar!!.setDisplayShowTitleEnabled(false)
//        actionBar!!.setDisplayHomeAsUpEnabled(true) // 뒤로가기 버튼, 디폴트로 true만 해도 백버튼이 생김


//        (getActivity() as AppCompatActivity?)!!.setSupportActionBar(tb)
//        val toolbar = view!!.findViewById<View>(R.id.topAppBar) as MaterialToolbar
//
//        val activity = getActivity() as AppCompatActivity?
//
//        activity!!.setSupportActionBar(toolbar)

        val mDrawerLayout: DrawerLayout? = getActivity()!!.findViewById(R.id.drawer_layout)

        // TopAppBar
        val topAppBar: MaterialToolbar? = getActivity()!!.findViewById<MaterialToolbar>(R.id.topAppBar)
        topAppBar!!.setNavigationOnClickListener {
            Toast.makeText(activity, "topAppBar Navigation A", Toast.LENGTH_SHORT).show()
            if (mDrawerLayout!!.isDrawerOpen(GravityCompat.START)) {
                mDrawerLayout!!.closeDrawer(GravityCompat.START)
            } else
                mDrawerLayout!!.openDrawer(GravityCompat.START)
        }

        // navigatoinView

        val navigationView: NavigationView = activity!!.findViewById<NavigationView>(R.id.nav_view)
        navigationView.menu.clear()
        navigationView.inflateMenu(R.menu.navigation_drawer_a)
        navigationView.setNavigationItemSelectedListener { menuItem ->
            mDrawerLayout!!.closeDrawer(GravityCompat.START)
            when(menuItem.itemId) {
                R.id.item1 -> {
                    Toast.makeText(activity, "item1_a",Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.item2 -> {
                    Toast.makeText(activity, "item2",Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.item3 -> {
                    Toast.makeText(activity, "item3",Toast.LENGTH_SHORT).show()
                    true
                }
                else->false
            }
        }


        return FragmentA
    }

    override fun onResume() {
        super.onResume()
        getActivity()!!.invalidateOptionsMenu()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_frag_a, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            R.id.frag_a -> Toast.makeText(getActivity(), "fragA", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }
}
