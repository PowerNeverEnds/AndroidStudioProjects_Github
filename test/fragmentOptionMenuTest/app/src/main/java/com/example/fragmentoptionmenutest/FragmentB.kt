package com.example.fragmentoptionmenutest

import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment


class FragmentB : Fragment() {
    private var FragmentB: LinearLayout? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        FragmentB = inflater.inflate(R.layout.fragment_b, container, false) as LinearLayout?
        setHasOptionsMenu(true)
        return FragmentB
    }

    override fun onResume() {
        super.onResume()
        getActivity()!!.invalidateOptionsMenu()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_frag_b, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            R.id.frag_b -> Toast.makeText(getActivity(), "fragB", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }
}
