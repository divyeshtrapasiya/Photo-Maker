package com.example.photoeditor.beautycamera.collagemaker.Adaptor

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class Store_Sticker_Adapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 1
    }

    override fun getItem(position: Int): Fragment {
        if (position == 0) {
            return Fragment()
        }
        return null!!
    }
}