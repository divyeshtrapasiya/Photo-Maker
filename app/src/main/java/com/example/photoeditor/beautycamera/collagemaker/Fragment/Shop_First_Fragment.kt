package com.example.photoeditor.beautycamera.collagemaker.Fragment


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.photoeditor.beautycamera.collagemaker.Adaptor.Store_Sticker_Adapter
import com.example.photoeditor.beautycamera.collagemaker.databinding.FragmentShopFirstBinding

import com.google.android.material.tabs.TabLayout

class Shop_First_Fragment : Fragment(){

    private lateinit var binding: FragmentShopFirstBinding
//    lateinit var adapter: CollageTemplateAdapter
//    lateinit var recyclerView: RecyclerView

//    companion object{
//        val context : Context? = null
//    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentShopFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        initView()
    }

//    private fun initView() {
//
//        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("All"))
//        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("birthday"))
////        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Calendar"))
////        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Christmas"))
////        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Family"))
////        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Frame"))
////        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Graduation"))
////        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Love"))
////        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Motherday"))
////        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Newyear"))
////        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Pride"))
////        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Schoollife"))
////        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Summer"))
////        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Travel"))
////        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Winter"))
//
//        val Myadapter = Store_Sticker_Adapter(childFragmentManager)
//        binding.viewpager.adapter = Myadapter
//
//        binding.viewpager.addOnPageChangeListener(object : TabLayout.TabLayoutOnPageChangeListener(binding.tabLayout) {})
//
//        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
//
//            override fun onTabSelected(tab: TabLayout.Tab?) {
//                if (tab != null) {
//                    binding.viewpager.currentItem = tab.position
//                }
//            }
//
//            override fun onTabUnselected(tab: TabLayout.Tab?) {
//            }
//
//            override fun onTabReselected(tab: TabLayout.Tab?) {
//
//            }
//            })
//        }
}