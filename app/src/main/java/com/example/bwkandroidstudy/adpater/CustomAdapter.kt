package com.example.bwkandroidstudy.adpater

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bwkandroidstudy.R
import com.example.bwkandroidstudy.data.CustomRecyclerItem

class CustomAdapter(private val dataSet: MutableList<CustomRecyclerItem>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    // 뷰 홀더
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val imageView: ImageView = view.findViewById(R.id.recycler_image)
        val textView: TextView = view.findViewById(R.id.recycler_text)
    }

    // 사용할 뷰 생성
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.recycler_default_view, parent, false)

        return ViewHolder(view)
    }

    // 뷰에 대한 데이터 초기화
    override fun onBindViewHolder(holder: CustomAdapter.ViewHolder, position: Int) {

        holder.textView.text = dataSet[position].title
        Glide.with(holder.imageView.context).load(R.drawable.ic_book_mark_24).into(holder.imageView)

        holder.textView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "${position+1} 번째 아이템", Toast.LENGTH_SHORT).show()
        }
        holder.imageView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "${position+1} 번째 아이템", Toast.LENGTH_SHORT).show()
        }
    }

    // 아이템 개수
    override fun getItemCount() = dataSet.size
}