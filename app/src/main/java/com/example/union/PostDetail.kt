package com.example.union

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PostDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_detail)
        val tv_detail_class = findViewById<TextView>(R.id.tv_detail_class)
        val tv_detail_title = findViewById<TextView>(R.id.tv_detail_title)
        val tv_detail_field = findViewById<TextView>(R.id.tv_detail_field)
        val tv_detail_registration = findViewById<TextView>(R.id.tv_detail_registration)
        val tv_detail_whether = findViewById<TextView>(R.id.tv_detail_whether)
        val tv_detail_date = findViewById<TextView>(R.id.tv_detail_date)
        val tv_detail_view = findViewById<TextView>(R.id.tv_detail_view)


        tv_detail_class.text = intent.getStringExtra("projectOrStudy")
        tv_detail_title.text = intent.getStringExtra("title")
        tv_detail_field.text = intent.getStringExtra("field")
        tv_detail_registration.text = intent.getStringExtra("registration")
        tv_detail_whether.text = intent.getStringExtra("whether")
        tv_detail_date.text = intent.getStringExtra("date")
        tv_detail_view.text = intent.getIntExtra("view",0).toString()

    }
}