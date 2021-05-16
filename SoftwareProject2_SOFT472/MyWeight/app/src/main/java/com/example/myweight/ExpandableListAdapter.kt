package com.example.myweight

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ExpandableListAdapter(private val data: MutableList<Item?>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder?>() {
    override fun onCreateViewHolder(parent: ViewGroup, type: Int): RecyclerView.ViewHolder {
        var view: View? = null
        val context = parent.context
        val dp = context.resources.displayMetrics.density
        val subItemPaddingLeft = (18 * dp).toInt()
        val subItemPaddingTopAndBottom = (5 * dp).toInt()
        when (type) {
            HEADER -> {
                val inflater =
                    parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                view = inflater.inflate(R.layout.list_header, parent, false)
                return ListHeaderViewHolder(view)
            }
            CHILD -> {
                val itemTextView = TextView(context)
                itemTextView.setPadding(
                    subItemPaddingLeft,
                    subItemPaddingTopAndBottom,
                    0,
                    subItemPaddingTopAndBottom
                )
                itemTextView.setTextColor(-0x78000000)
                itemTextView.layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
                return object : RecyclerView.ViewHolder(itemTextView) {}
            }
        }
        return null!!
//        return RecyclerView.ViewHolder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var item = data[position]
        when (item!!.type) {
            HEADER -> {
                val itemController = holder as ListHeaderViewHolder?
                itemController!!.refferalItem = item
                itemController.header_title.text = item.text
                if (item.invisibleChildren == null) {
                    itemController.btn_expand_toggle.setImageResource(R.drawable.ic_baseline_expand_less_24)
                } else {
                    itemController.btn_expand_toggle.setImageResource(R.drawable.ic_baseline_expand_more_24)
                }
                itemController.btn_expand_toggle.setOnClickListener {
                    if (item.invisibleChildren == null) {
                        item.invisibleChildren = ArrayList()
                        var count = 0
                        val pos = data.indexOf(itemController.refferalItem)
                        while (data.size > pos + 1 && data[pos + 1]!!.type == CHILD) {
//                            val dataTemp: Item? = data[pos+1]
                            (item.invisibleChildren as ArrayList<Item?>).add(data.removeAt(pos+1))
//                            data.removeAt(pos+1)
                            count++
                        }
                        notifyItemRangeRemoved(pos + 1, count)
                        itemController.btn_expand_toggle.setImageResource(R.drawable.ic_baseline_expand_more_24)
                    } else {
                        val pos = data.indexOf(itemController.refferalItem)
                        var index = pos + 1
                        for (i in item.invisibleChildren!!) {
                            data.add(index, i)
                            index++
                        }
                        notifyItemRangeInserted(pos + 1, index - pos - 1)
                        itemController.btn_expand_toggle.setImageResource(R.drawable.ic_baseline_expand_less_24)
                        item.invisibleChildren = null
                    }
                }
            }
            CHILD -> {
                val itemTextView = holder!!.itemView as TextView
                itemTextView.text = data[position]!!.text
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return data[position]!!.type
    }

    override fun getItemCount(): Int {
        return data.size
    }

    private class ListHeaderViewHolder(itemView: View?) :
        RecyclerView.ViewHolder(itemView!!) {
        var header_title: TextView
        var btn_expand_toggle: ImageView
        var refferalItem: Item? = null

        init {
            header_title = itemView!!.findViewById<View>(R.id.header_title) as TextView
            btn_expand_toggle = itemView.findViewById<View>(R.id.btn_expand_toggle) as ImageView
        }
    }

    class Item {
        var type = 0
        var text: String? = null
        var invisibleChildren: MutableList<Item?>? = null

        constructor() {}
        constructor(type: Int, text: String?) {
            this.type = type
            this.text = text
        }
    }

    companion object {
        const val HEADER = 0
        const val CHILD = 1
    }
}
