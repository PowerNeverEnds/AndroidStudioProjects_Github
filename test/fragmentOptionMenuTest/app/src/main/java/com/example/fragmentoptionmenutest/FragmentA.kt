package com.example.fragmentoptionmenutest

import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment


class FragmentA : Fragment() {
    private var FragmentA: LinearLayout? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        FragmentA = inflater.inflate(R.layout.fragment_a, container, false) as LinearLayout?
        setHasOptionsMenu(true)
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
