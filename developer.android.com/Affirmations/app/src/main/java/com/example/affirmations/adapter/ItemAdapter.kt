package com.example.affirmations.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.R
import com.example.affirmations.model.Affirmation

/*
https://medium.com/hongbeomi-dev/%EB%B2%88%EC%97%AD-recyclerview%EC%9D%98-%EB%82%B4%EB%B6%80-%EB%8F%99%EC%9E%91-941a2827fa5a
https://medium.com/1mgofficial/how-recyclerview-works-internally-71290de5d2c4
내리다가 올리게될때,(기본로직은 맨밑에)
계속 내리면, 맨위부터 순서대로 ScrapView상태가되어 나머지 로직을거치고,
다시 올릴경우, ScrapView의 콘텐츠(여기서는 strings.xml 의 affirmation 문자열)는 맨위에있고,
DirtyView에는 맨위의 콘텐츠가 있고,
따라서 바인딩할때, println(S) 는 맨위(DirtyView이므로), println(E)는 새로운 콘텐츠도 맨위(위로올렸기때문에)
string 값이 같은건 이때문임.
기본로직
화면에 보이는거 create,
스크롤되어 보이지 않게 되면 ScrapView,
새로 화면에 보여야할때,
.ScrapView가 있으면 DirtyView로 재사용,
.없으면 create
후 바인딩

http://blog.naver.com/PostView.nhn?blogId=mail1001&logNo=220682221473&parentCategoryNo=&categoryNo=&viewDate=&isShowPopularPosts=false&from=postList
https://wooooooak.github.io/android/2019/03/28/recycler_view/
참고할만한거

https://wholeman.dev/wiki/recyclerview-inside
호출순서참고
getItemCount -> getItemViewType -> onCreateViewHolder -> onBindViewHolder

 */
class ItemAdapter (
        private val context: Context,
        private val dataset:List<Affirmation>
        ) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    class ItemViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
        val imageView: ImageView = view.findViewById(R.id.item_image)
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
        holder.imageView.setImageResource(item.imageResourceId)
        println("E Bind: ${holder.textView.text}")
        println()
    }

    override fun getItemCount(): Int {
//        println("Count: ${dataset.size} ${n++}")
        return dataset.size
    }
}
