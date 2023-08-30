package com.example.fragmenttest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.union.NavBottomAll
import com.example.union.R

class ProfileAdapter(private var context: NavBottomAll) : RecyclerView.Adapter<ProfileAdapter.ViewHolder>()
{


    var datas = mutableListOf<ProfileData>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
        }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])
        holder.itemView.setOnClickListener{
            itemClickListener.onClick(it, position)
        }
    }

    interface OnItemClickListener {
        fun onClick(v: View, position: Int)
    }
    companion object {
        fun setItemClickListener(onItemClickListener: OnItemClickListener) {
            this.itemClickListener = onItemClickListener
        }
        private lateinit var itemClickListener : OnItemClickListener
    }





    override fun getItemCount(): Int {
        return datas.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val profileImage = itemView.findViewById<ImageView>(R.id.iv_list_profile)  //프로필 사진
        val projectOrStudy = itemView.findViewById<TextView>(R.id.tv_list_class)        //프로젝트 or 스터디
        val title = itemView.findViewById<TextView>(R.id.tv_list_title)          //Title
        val field = itemView.findViewById<TextView>(R.id.tv_list_field)          //분야
        val registration = itemView.findViewById<TextView>(R.id.tv_list_registration)          //등록자
        val whether = itemView.findViewById<TextView>(R.id.tv_list_whether)          //마감여부
        val view = itemView.findViewById<TextView>(R.id.tv_list_view)          //조회수
        val date = itemView.findViewById<TextView>(R.id.tv_list_date)          //마감일자

        fun bind(item: ProfileData) {
            projectOrStudy.text = item.projectOrStudy
            title.text = item.title
            field.text = item.field
            registration.text = item.registration
            whether.text = item.whether
            view.text = item.view.toString()
            date.text = item.date.toString()
            Glide.with(itemView).load(item.profileImage).into(profileImage)
        }

    }


}
