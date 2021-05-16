package com.example.myweight

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
//import android.widget.ExpandableListAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myweight.ExpandableListAdapter
import com.example.myweight.ExpandableListAdapter.Item

class AddFragment:Fragment() {

    private var recyclerview: RecyclerView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v: View = inflater.inflate(R.layout.fragment_add, container, false)

        Toast.makeText(this.context, "success!", Toast.LENGTH_SHORT).show()

//        안드로이드 개발 Fragment 와 Activity 의 통신하는 방법
//        https://mainia.tistory.com/5676
        val tv:TextView = getActivity()!!.findViewById(R.id.textView)
        tv!!.setText("success!")


        recyclerview = v.findViewById(R.id.recyclerview_add)
        recyclerview!!.setLayoutManager(
            LinearLayoutManager(
                this.context,
                LinearLayoutManager.VERTICAL,
                false
            )
        )

        val data: MutableList<ExpandableListAdapter.Item?> = ArrayList()

//        data.add(
//            ExpandableListAdapter.Item(
//                ExpandableListAdapter.HEADER, "Fruits"))
//        data.add(Item(ExpandableListAdapter.CHILD, "Apple"))
//        data.add(Item(ExpandableListAdapter.CHILD, "Orange"))
//        data.add(Item(ExpandableListAdapter.CHILD, "Banana"))
//        data.add(Item(ExpandableListAdapter.HEADER, "Cars"))
//        data.add(Item(ExpandableListAdapter.CHILD, "Audi"))
//        data.add(Item(ExpandableListAdapter.CHILD, "Aston Martin"))
//        data.add(Item(ExpandableListAdapter.CHILD, "BMW"))
//        data.add(Item(ExpandableListAdapter.CHILD, "Cadillac"))

        var pla: ExpandableListAdapter.Item
        pla = Item(
                ExpandableListAdapter.HEADER, "Fruits")
        pla.invisibleChildren = ArrayList()
        pla.invisibleChildren?.add(Item(ExpandableListAdapter.CHILD, "Apple"))
        pla.invisibleChildren?.add(Item(ExpandableListAdapter.CHILD, "Orange"))
        pla.invisibleChildren?.add(Item(ExpandableListAdapter.CHILD, "Banana"))
        data.add(pla)
        pla = (Item(ExpandableListAdapter.HEADER, "Cars"))
        pla.invisibleChildren = ArrayList()
        pla.invisibleChildren?.add(Item(ExpandableListAdapter.CHILD, "Audi"))
        pla.invisibleChildren?.add(Item(ExpandableListAdapter.CHILD, "Aston Martin"))
        pla.invisibleChildren?.add(Item(ExpandableListAdapter.CHILD, "BMW"))
        pla.invisibleChildren?.add(Item(ExpandableListAdapter.CHILD, "Cadillac"))
        data.add(pla)

        val places: ExpandableListAdapter.Item = Item(
            ExpandableListAdapter.HEADER, "Places")
        places.invisibleChildren = ArrayList()
        places.invisibleChildren?.add(Item(ExpandableListAdapter.CHILD, "Kerala"))
        places.invisibleChildren?.add(Item(ExpandableListAdapter.CHILD, "Tamil Nadu"))
        places.invisibleChildren?.add(Item(ExpandableListAdapter.CHILD, "Karnataka"))
        places.invisibleChildren?.add(Item(ExpandableListAdapter.CHILD, "Maharashtra"))

        data.add(places)

        recyclerview!!.adapter =
            ExpandableListAdapter(data)

        return v
    }
}