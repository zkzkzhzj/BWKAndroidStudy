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

// 여러 개의 ViewHolder 를 사용하기 위해서 RecyclerView.ViewHolder 를 사용
class MyAdapter(private val dataSet: MutableList<CustomRecyclerItem>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    /*
     * 뷰 홀더란 뭘까??
     * 각 뷰 를 보관하는 객체라고 이야기 할 수 있다
     * 해당하는 뷰를 뷰 홀더에 저장해두어서 데이터의 변경이 있을 때
     * 매번 새롭게 접근하는 것이 아니라 저장해둔 뷰를 가져와서
     * 바로 엑세스하여 사용할 수 있게 하는 것
     * 뷰 홀더 패턴 이라고 한다
     */

    // 어떤 ViewHolder 인지 체크하기 위한 체크
    private val HEADER = 0
    private val BODY = 1

    // 헤더 뷰 홀더 생성
    class HeaderViewHolder(private val view: View): RecyclerView.ViewHolder(view){

    }

    // 바디 뷰 홀더 생성
    class BodyViewHolder(private val view: View): RecyclerView.ViewHolder(view){
        val imageView: ImageView = view.findViewById(R.id.recycler_image)
        val textView: TextView = view.findViewById(R.id.recycler_text)
    }

    // 뷰 타입을 리턴함(position 값을 계산해서 리턴)
    override fun getItemViewType(position: Int): Int {
        return when(position){
            0 -> HEADER
            else -> BODY
        }
    }

    // 위에서 확인하고 리턴해준 뷰 타입을 비교하여 알맞은 레이아웃을 넣은 뷰 홀더 반환
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            HEADER -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_header_view, parent, false)
                HeaderViewHolder(view)
            }
            else -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_default_view, parent, false)
                BodyViewHolder(view)
            }
        }
    }

    // 뷰 홀더 생성자에서 생성해준 뷰 홀더를 가져와서 사용
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        // 뷰 홀더를 체크하여 해당하는 홀더에 맞는 아이템 세팅 및 동작 정의
        when(holder){
            is HeaderViewHolder -> {

            }

            // 여기서는 헤더가 포지션을 차지하고 있으므로 dataSet 에서 꺼낼때 포지션 -1 과 Toast 메시지를 뽑을 때 +1 안해주어야 한다
            // 리사이클러 자체에서 지원하는 ConcatAdapter 는 어뎁터 2개를 이어 붙이기 때문에 다르
            is BodyViewHolder -> {
                holder.textView.text = dataSet[position-1].title
                Glide.with(holder.imageView.context).load(dataSet[position-1].image).into(holder.imageView)

                holder.textView.setOnClickListener {
                    Toast.makeText(holder.itemView.context, "$position 번째 아이템", Toast.LENGTH_SHORT).show()
                }
                holder.imageView.setOnClickListener {
                    Toast.makeText(holder.itemView.context, "$position 번째 아이템", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    // 헤더가 포함되었으므로 데이터 사이즈에 1 증가 시킨 값 리턴
    override fun getItemCount(): Int {
        return dataSet.size + 1
    }
}