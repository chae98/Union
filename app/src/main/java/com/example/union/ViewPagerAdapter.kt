package com.example.union

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class ViewPagerAdapter(noticeList: ArrayList<Int>) : RecyclerView.Adapter<ViewPagerAdapter.PagerViewHolder>() {
    class PagerViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.notice_list_item, parent, false)) {
        val notice = itemView.findViewById<ImageView>(R.id.img_notice)
    }
    var item = noticeList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PagerViewHolder((parent))

    override fun getItemCount(): Int = Int.MAX_VALUE
    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.notice.setImageResource(item[position%3])
    }
}