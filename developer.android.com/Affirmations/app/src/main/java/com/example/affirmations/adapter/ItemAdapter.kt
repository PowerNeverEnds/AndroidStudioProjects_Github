package com.example.affirmations.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.R
import com.example.affirmations.model.Affirmation


class ItemAdapter (
        private val context: Context,
        private val dataset:List<Affirmation>
        ) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    class ItemViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
    }
    var n=0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item,parent,false)
        // true는 다음의 오류가 나타남.
//        java.lang.IllegalStateException: ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)
//                .inflate(R.layout.list_item,parent,true)
        println("Create: ${adapterLayout}")
        // onCreateViewHolder는 다음과 같이 1번만 실행됨
//        I/System.out: Create: com.google.android.material.textview.MaterialTextView{18353da V.ED..... ......ID 0,0-0,0 #7f0800b6 app:id/item_title}
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item  = dataset[position]
        println("S Bind: ${holder.textView.text}")
        holder.textView.text = context.resources.getString(item.stringResourceId)
        println("E Bind: ${holder.textView.text}")
        println()
    }

    override fun getItemCount(): Int {
//        println("Count: ${dataset.size} ${n++}")
        return dataset.size
    }
}
