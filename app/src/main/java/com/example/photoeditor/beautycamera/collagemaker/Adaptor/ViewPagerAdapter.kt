package com.example.photoeditor.beautycamera.collagemaker.Adaptor

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.photoeditor.beautycamera.collagemaker.Fragment.Shop_First_Fragment
import com.example.photoeditor.beautycamera.collagemaker.Fragment.Shop_Four_Fragment
import com.example.photoeditor.beautycamera.collagemaker.Fragment.Shop_Second_Fragment
import com.example.photoeditor.beautycamera.collagemaker.Fragment.Shop_Third_Fragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    private val fragmentList = listOf(
        Shop_First_Fragment(),
        Shop_Second_Fragment(),
        Shop_Third_Fragment(),
        Shop_Four_Fragment(),

    )

    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }
}
