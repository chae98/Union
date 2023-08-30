package com.example.union

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainPage : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {

//    lateinit var profileAdapter: ProfileAdapter
//    val datas = mutableListOf<ProfileData>()


//    private val TAG = this.javaClass.simpleName
    private val callback = object : OnBackPressedCallback(true){
        override fun handleOnBackPressed() { //네비게이션 뷰 뒤로가기 버튼 작동
            var layout_drawer = findViewById<DrawerLayout>(R.id.layout_drawer)
            layout_drawer.closeDrawer(GravityCompat.END)
        }
    }

//    private val currentPosition = Int.MAX_VALUE / 2
//    private val intervalTime = 1500.toLong()
//    private val myHandler = MyHandler()


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_page)

//        ViewPager2
//        val viewPager_notice = findViewById<ViewPager2>(R.id.viewPager_notice)
//
//        viewPager_notice.adapter = ViewPagerAdapter(getNoitceList())
//        viewPager_notice.orientation = ViewPager2.ORIENTATION_HORIZONTAL
//        viewPager_notice.setCurrentItem(currentPosition, false)
//
//        viewPager_notice.apply {
//            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
//                override fun onPageScrollStateChanged(state: Int) {
//                    super.onPageScrollStateChanged(state)
//                    when (state) {
//                        ViewPager2.SCROLL_STATE_IDLE -> autoScrollStart(intervalTime)
//                        ViewPager2.SCROLL_STATE_DRAGGING -> autoScrollStop()
//                    }
//                }
//            })
//        }









//        BottomNavigationView

        supportFragmentManager.beginTransaction().replace(R.id.frame_layout,NavBottomAll()).commit()

        val nav_main_bottom = findViewById<BottomNavigationView>(R.id.nav_main_bottom)

        nav_main_bottom.setOnItemSelectedListener {
            when(it.itemId){
                R.id.nav_bottom_all -> {
                    supportFragmentManager.beginTransaction().replace(R.id.frame_layout,NavBottomAll()).commit()
                }
                R.id.nav_bottom_project -> {
                    supportFragmentManager.beginTransaction().replace(R.id.frame_layout,NavBottomProject()).commit()
                }
                R.id.nav_bottom_study -> {
                    supportFragmentManager.beginTransaction().replace(R.id.frame_layout,NavBottomStudy()).commit()
                }
            }
            true
        }


//        리사이클러 뷰
//        var binding = ActivityMainBinding.inflate(layoutInflater)
//        var view = binding.root
//        initRecycler()

//        ProfileAdapter.setItemClickListener(object: ProfileAdapter.OnItemClickListener{
//            override fun onClick(v: View, position: Int) {
//                // 클릭 시 이벤트 작성
//                Toast.makeText(view.context,
//                    "${datas[position].title}\n${datas[position].registration}",
//                    Toast.LENGTH_SHORT).show()
//                val intent = Intent(this@MainPage, PostDetail::class.java)
//
//                intent.putExtra("projectOrStudy", datas[position].projectOrStudy)
//                intent.putExtra("title", datas[position].title)
//                intent.putExtra("field", datas[position].field)
//                intent.putExtra("registration", datas[position].registration)
//                intent.putExtra("whether", datas[position].whether)
//                intent.putExtra("view", datas[position].view)
//                intent.putExtra("date", datas[position].date)
//                startActivity(intent)
//
//            }
//        })





//        네이게이션 뷰
        this.onBackPressedDispatcher.addCallback(this, callback)

        val layout_drawer = findViewById<DrawerLayout>(R.id.layout_drawer)
        val btn_main_profile = findViewById<ImageView>(R.id.btn_main_profile)
        val naviView = findViewById<NavigationView>(R.id.naviView)

        btn_main_profile.setOnClickListener{
            layout_drawer.openDrawer(GravityCompat.END)
        }
        naviView.setNavigationItemSelectedListener(this)

    }

//    private fun autoScrollStart(intervalTime: Long){
//        myHandler.removeMessages(0)
//        myHandler.sendEmptyMessageDelayed(0, intervalTime)
//    }
//    private fun autoScrollStop(){
//        myHandler.removeMessages(0)
//    }
//
//    @Suppress("DEPRECATION")
//    private inner class MyHandler : Handler() {
//        override fun handleMessage(msg: Message) {
//            super.handleMessage(msg)
//            val viewPager_notice = findViewById<ViewPager2>(R.id.viewPager_notice)
//
//            if(msg.what == 0){
//                viewPager_notice.setCurrentItem(currentPosition, true) //다음 페이지 이동
//                autoScrollStart(intervalTime)
//            }
//        }
//    }
//    //다른 페이지 갔다가 돌아오면 다시 시작
//    override fun onRestart() {
//        super.onRestart()
//        autoScrollStart(intervalTime)
//    }
//    //다른 페이지에 있는 동안 스탑
//    override fun onPause() {
//        super.onPause()
//        autoScrollStop()
//    }
//
//    private fun getNoitceList(): ArrayList<Int> {
//        return arrayListOf<Int>(R.drawable.notice1, R.drawable.notice2, R.drawable.notice3)
//    }



    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val layout_drawer = findViewById<DrawerLayout>(R.id.layout_drawer)
        when (item.itemId){
            R.id.navi_new_posting -> startActivity(Intent(this, NewPosting::class.java))
            R.id.navi_my_posting -> Toast.makeText(applicationContext, "내 작성글", Toast.LENGTH_SHORT).show()
            R.id.navi_interest -> Toast.makeText(applicationContext, "내 관심글", Toast.LENGTH_SHORT).show()
            R.id.navi_profile -> startActivity(Intent(this, ProfilePage::class.java))
            R.id.navi_logout -> Toast.makeText(applicationContext, "로그아웃", Toast.LENGTH_SHORT).show()
        }
        layout_drawer.closeDrawers()
        return false
    }

//    private fun initRecycler() {
//        profileAdapter = ProfileAdapter(this)
//        val rv_profile = findViewById<RecyclerView>(R.id.rv_mainPage)
//        rv_profile.adapter = profileAdapter
//
//
//        datas.apply {
//            add(ProfileData(R.drawable.man, "프로젝트","제목입니다", "안드로이드", "쭌식이", "Open", 1, "2023-08-26"))
//            add(ProfileData(R.drawable.woman, "스터디" ,"제목입니닷", "IOS", "제식이", "Close", 1000, "2023-08-25"))
//            add(ProfileData(R.drawable.man, "프로젝트","제목입니다", "안드로이드", "쭌식이", "Open", 1, "2023-08-24"))
//            add(ProfileData(R.drawable.woman, "스터디" ,"제목입니닷", "IOS", "제식이", "Close", 1000, "2023-08-23"))
//            add(ProfileData(R.drawable.man, "프로젝트","제목입니다", "안드로이드", "쭌식이", "Open", 1, "2023-08-22"))
//            add(ProfileData(R.drawable.woman, "스터디" ,"제목입니닷", "IOS", "제식이", "Close", 1000, "2023-08-21"))
//            add(ProfileData(R.drawable.man, "프로젝트","제목입니다", "안드로이드", "쭌식이", "Open", 1, "2023-08-27"))
//            add(ProfileData(R.drawable.woman, "스터디" ,"제목입니닷", "IOS", "제식이", "Close", 1000, "2023-08-28"))
//
//            profileAdapter.datas = datas
//            profileAdapter.notifyDataSetChanged()
//
//        }
//    }
}