package com.example.bwkandroidstudy.adpater

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bwkandroidstudy.R

class HeaderAdapter : RecyclerView.Adapter<HeaderAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeaderAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_header_view, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: HeaderAdapter.ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int = 1
}