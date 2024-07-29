package com.example.photoeditor.beautycamera.collagemaker.Adaptor

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.photoeditor.beautycamera.collagemaker.Fragment.Shop_Four_Fragment
import com.example.photoeditor.beautycamera.collagemaker.Fragment.Shop_Second_Fragment
import com.example.photoeditor.beautycamera.collagemaker.Fragment.Shop_Third_Fragment

class StoreAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        if (position == 0) {
            return Shop_Third_Fragment()
        } else if (position == 1) {
            return Shop_Second_Fragment()
        } else if (position == 2) {
            return Shop_Four_Fragment()
        }
        return null!!
    }
}