package com.example.gua4_v1_0

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView

class homepage : AppCompatActivity() {

    val fragmentList = listOf(Homefragment(),uploading(),Myself())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)
        val contentViewPager = findViewById<ViewPager>(R.id.content_view_pager)
        //碎片尽量用前缓存
        contentViewPager.offscreenPageLimit = 3//缓存
        contentViewPager.adapter = nav_Adapter(supportFragmentManager)
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav)
        bottomNav.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_home -> contentViewPager.currentItem = 0
                R.id.nav_uploading -> contentViewPager.currentItem = 1
                R.id.nav_myself -> contentViewPager.currentItem = 2
            }
            false
        }
        contentViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                bottomNav.menu.getItem(position).isChecked =true
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })
    }

    inner class nav_Adapter(fm:FragmentManager):FragmentPagerAdapter(fm,
        BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){
        override fun getCount(): Int {
            return fragmentList.size
        }

        override fun getItem(position: Int): Fragment {
            return fragmentList[position]
        }
    }
    fun has_changed(view1: View){
        Toast.makeText(
            this,
            "修改成功！",
            Toast.LENGTH_LONG
        ).show()
    }
}