package com.example.photoeditor.beautycamera.collagemaker.Template_Activity

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.example.photoeditor.beautycamera.collagemaker.Adaptor.TemplatesViewPagerAdapter
import com.example.photoeditor.beautycamera.collagemaker.R
import com.example.photoeditor.beautycamera.collagemaker.Template_Fragment.*
import com.example.photoeditor.beautycamera.collagemaker.databinding.ActivityTemplatesBinding

class Templates_Activity : AppCompatActivity() {

    private lateinit var binding: ActivityTemplatesBinding
    private lateinit var categoryViews: List<LinearLayout>
    private lateinit var categoryTexts: List<TextView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTemplatesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        setupViewPager()
        setupCategoryClickListeners()
        setupViewPagerListener()
    }

    private fun setupViewPager() {
        val adapter = TemplatesViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(All_Templates())
        binding.viewPager.adapter = adapter
    }

    private fun setupCategoryClickListeners() {
//        categoryViews = listOf(binding.allCategory)
//        categoryTexts = listOf(binding.allCategory.findViewById(R.id.allCategoryText))
//        for (i in categoryViews.indices) {
//            categoryViews[i].setOnClickListener { onCategorySelected(i) }
//        }
    }

    private fun setupViewPagerListener() {
        binding.viewPager.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

            override fun onPageSelected(position: Int) {
                updateCategoryUI(position)
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })
    }

    private fun onCategorySelected(position: Int) {
        binding.viewPager.currentItem = position
    }

    private fun updateCategoryUI(selectedPosition: Int) {
        for (i in categoryViews.indices) {
            if (i == selectedPosition) {
                categoryViews[i].setBackgroundResource(R.drawable.template_select_background)
                categoryTexts[i].setTextColor(ContextCompat.getColor(this, R.color.white))
            } else {
                categoryViews[i].setBackgroundResource(R.drawable.button_background_unselected)
                categoryTexts[i].setTextColor(ContextCompat.getColor(this, R.color.black))
            }
        }
    }
}
