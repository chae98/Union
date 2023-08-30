package com.example.union

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.fragmenttest.ProfileAdapter
import com.example.fragmenttest.ProfileData
import com.example.union.databinding.ActivityMainBinding


class NavBottomAll : Fragment() {
    lateinit var profileAdapter: ProfileAdapter
    val datas = mutableListOf<ProfileData>()
    private val currentPosition = Int.MAX_VALUE / 2
    private val intervalTime = 1500.toLong()
    private val myHandler = MyHandler()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nav_bottom_all, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        var binding = ActivityMainBinding.inflate(layoutInflater)
        var view = binding.root

        val viewPager_notice: ViewPager2 = view.findViewById(R.id.viewPager_notice)

        viewPager_notice.adapter = ViewPagerAdapter(getNoitceList())
        viewPager_notice.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        viewPager_notice.setCurrentItem(currentPosition, false)

        viewPager_notice.apply {
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageScrollStateChanged(state: Int) {
                    super.onPageScrollStateChanged(state)
                    when (state) {
                        ViewPager2.SCROLL_STATE_IDLE -> autoScrollStart(intervalTime)
                        ViewPager2.SCROLL_STATE_DRAGGING -> autoScrollStop()
                    }
                }
            })
        }




        initRecycler()

        ProfileAdapter.setItemClickListener(object: ProfileAdapter.OnItemClickListener{
            override fun onClick(v: View, position: Int) {
                // 클릭 시 이벤트 작성
                Toast.makeText(view.context,
                    "${datas[position].title}\n${datas[position].registration}",
                    Toast.LENGTH_SHORT).show()
                val intent = Intent(context, PostDetail::class.java)

                intent.putExtra("projectOrStudy", datas[position].projectOrStudy)
                intent.putExtra("title", datas[position].title)
                intent.putExtra("field", datas[position].field)
                intent.putExtra("registration", datas[position].registration)
                intent.putExtra("whether", datas[position].whether)
                intent.putExtra("view", datas[position].view)
                intent.putExtra("date", datas[position].date)
                startActivity(intent)

            }
        })





    }
    private fun autoScrollStart(intervalTime: Long){
        myHandler.removeMessages(0)
        myHandler.sendEmptyMessageDelayed(0, intervalTime)
    }
    private fun autoScrollStop(){
        myHandler.removeMessages(0)
    }

    @Suppress("DEPRECATION")
    private inner class MyHandler : Handler() {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            val viewPager_notice: ViewPager2 = view!!.findViewById(R.id.viewPager_notice)

            if(msg.what == 0){
                viewPager_notice.setCurrentItem(currentPosition, true) //다음 페이지 이동
                autoScrollStart(intervalTime)
            }
        }
    }
    //다른 페이지 갔다가 돌아오면 다시 시작
//    override fun onRestart() {
//        super.onRestart()
//        autoScrollStart(intervalTime)
//    }
//    //다른 페이지에 있는 동안 스탑
//    override fun onPause() {
//        super.onPause()
//        autoScrollStop()
//    }

    private fun getNoitceList(): ArrayList<Int> {
        return arrayListOf<Int>(R.drawable.notice1, R.drawable.notice2, R.drawable.notice3)
    }
    private fun initRecycler() {
        profileAdapter = ProfileAdapter(this)
        val rv_profile: RecyclerView = requireView().findViewById(R.id.rv_mainPage)
        rv_profile.adapter = profileAdapter


        datas.apply {
            add(ProfileData(R.drawable.man, "프로젝트","제목입니다", "안드로이드", "쭌식이", "Open", 1, "2023-08-26"))
            add(ProfileData(R.drawable.woman, "스터디" ,"제목입니닷", "IOS", "제식이", "Close", 1000, "2023-08-25"))
            add(ProfileData(R.drawable.man, "프로젝트","제목입니다", "안드로이드", "쭌식이", "Open", 1, "2023-08-24"))
            add(ProfileData(R.drawable.woman, "스터디" ,"제목입니닷", "IOS", "제식이", "Close", 1000, "2023-08-23"))
            add(ProfileData(R.drawable.man, "프로젝트","제목입니다", "안드로이드", "쭌식이", "Open", 1, "2023-08-22"))
            add(ProfileData(R.drawable.woman, "스터디" ,"제목입니닷", "IOS", "제식이", "Close", 1000, "2023-08-21"))
            add(ProfileData(R.drawable.man, "프로젝트","제목입니다", "안드로이드", "쭌식이", "Open", 1, "2023-08-27"))
            add(ProfileData(R.drawable.woman, "스터디" ,"제목입니닷", "IOS", "제식이", "Close", 1000, "2023-08-28"))

            profileAdapter.datas = datas
            profileAdapter.notifyDataSetChanged()

        }
    }



}