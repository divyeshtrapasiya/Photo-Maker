package com.example.photoeditor.beautycamera.collagemaker.Activity

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.photoeditor.beautycamera.collagemaker.Adaptor.StoreAdapter
import com.example.photoeditor.beautycamera.collagemaker.Adaptor.ViewPagerAdapter
import com.example.photoeditor.beautycamera.collagemaker.R
import com.example.photoeditor.beautycamera.collagemaker.databinding.ActivityShopBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class Shop_Activity : AppCompatActivity() {

    private lateinit var binding: ActivityShopBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShopBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
//        {
//            val window = window
//            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
//            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
//            window.statusBarColor = ContextCompat.getColor(this, R.color.white)
//        }
//
//        window.navigationBarColor = ContextCompat.getColor(this, R.color.black)


        initView()

    }


//    private fun initview() {
//
//        binding.backButton.setOnClickListener { onBackPressed()}
//
//        binding.tabLayout.addTab(binding.tabLayout.newTab().setIcon(R.drawable.sticker))
//        binding.tabLayout.addTab(binding.tabLayout.newTab().setIcon(R.drawable.tab_icon_2))
//        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Light FX"))
//        binding.tabLayout.addTab(binding.tabLayout.newTab().setIcon(R.drawable.font))
//        binding.tabLayout.addTab(binding.tabLayout.newTab().setIcon(R.drawable.filter))
//
//
//        val Myadapter = StoreAdapter(supportFragmentManager)
//        binding.viewPager.adapter = Myadapter
//
//        binding.viewPager.addOnPageChangeListener(object : TabLayout.TabLayoutOnPageChangeListener(binding.tabLayout){})
//
//        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
//
//            override fun onTabSelected(tab: TabLayout.Tab?)
//            {
//                if(tab != null)
//                {
//                    binding.viewPager.currentItem = tab.position
//                }
//            }
//
//            override fun onTabUnselected(tab: TabLayout.Tab?)
//            {
//
//            }
//
//            override fun onTabReselected(tab: TabLayout.Tab?)
//            {
//
//            }
//
//            })
//        }
//}

    @SuppressLint("InflateParams")
    private fun initView() {


        val adapter = ViewPagerAdapter(this)
        binding.viewPager.adapter = adapter

        val tabIcons = arrayOf(R.drawable.sticker, R.drawable.tab_icon_2, R.drawable.font, R.drawable.filter)

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            val customTab: View = LayoutInflater.from(this).inflate(R.layout.tab_item, null)
            val tabIcon: ImageView = customTab.findViewById(R.id.tab_icon)
            tabIcon.setImageResource(tabIcons[position])
            tab.customView = customTab
        }.attach()

    }

}
