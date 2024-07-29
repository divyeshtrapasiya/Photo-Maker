package com.example.photoeditor.beautycamera.collagemaker.Activity

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.photoeditor.beautycamera.collagemaker.Adaptor.SliderAdapter
import com.example.photoeditor.beautycamera.collagemaker.Collage_Activity.Collage_image_Activity
import com.example.photoeditor.beautycamera.collagemaker.Edit_Activity.Edit_Gallery_image_Activity
import com.example.photoeditor.beautycamera.collagemaker.Freesytle_Activity.Freestyle_Add_Image_Activity
import com.example.photoeditor.beautycamera.collagemaker.Freesytle_Activity.Freestyle_Edit_Image_Activity
import com.example.photoeditor.beautycamera.collagemaker.Freesytle_Activity.Freestyle_Image_Select_Activity
import com.example.photoeditor.beautycamera.collagemaker.R
import com.example.photoeditor.beautycamera.collagemaker.Setting_Activity.Setting_Activity
import com.example.photoeditor.beautycamera.collagemaker.Template_Activity.Templates_Activity
import com.example.photoeditor.beautycamera.collagemaker.databinding.ActivityHomepageBinding

class HomePageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomepageBinding

    private val imageSlider = arrayListOf(
        R.drawable.featuredimage,
        R.drawable.grid_eid,
        R.drawable.grid_congrutulation,
        R.drawable.grid_love,
        R.drawable.grid_summer,
        R.drawable.grid_ai,
        R.drawable.grid_removeobject,
        R.drawable.grid_collage,
        R.drawable.grid_calender,
        R.drawable.grid_remove_bg,
        R.drawable.grid_freestyle
    )

    private lateinit var viewPager: ViewPager
    private lateinit var dotsLayout: LinearLayout
    private lateinit var dots: Array<ImageView?>
    private val NUM_PAGES = imageSlider.size

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomepageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        viewPager = findViewById(R.id.viewpager)
        dotsLayout = findViewById(R.id.dotsLayout)

        val sliderAdapter = SliderAdapter(imageSlider, this)
        viewPager.adapter = sliderAdapter

        addDotsIndicator()
        viewPager.addOnPageChangeListener(viewListener)

        binding.LinearCollage.setOnClickListener {
            val intent = Intent(this@HomePageActivity, Collage_image_Activity::class.java)
            startActivity(intent)
            finish()
        }

        binding.linearTemplates.setOnClickListener {
            val intent = Intent(this@HomePageActivity, Templates_Activity::class.java)
            startActivity(intent)
            finish()
        }

        binding.cartIcon.setOnClickListener {
            val intent = Intent(this@HomePageActivity, Shop_Activity::class.java)
            startActivity(intent)
            finish()
        }

        binding.linearFreestyle.setOnClickListener {
            val intent = Intent(this@HomePageActivity, Freestyle_Image_Select_Activity::class.java)
            startActivity(intent)
            finish()
        }

        binding.menuIcon.setOnClickListener {
            val intent = Intent(this@HomePageActivity, Setting_Activity::class.java)
            startActivity(intent)
        }

        binding.linearEdit.setOnClickListener {
            val intent = Intent(this@HomePageActivity, Edit_Gallery_image_Activity::class.java)
            startActivity(intent)
            finish()
        }


        binding.crownIcon.setOnClickListener {
            val intent = Intent(this@HomePageActivity, Purchase_Activity::class.java)
            startActivity(intent)
            finish()
        }

    }

    private fun addDotsIndicator() {
        dots = arrayOfNulls(NUM_PAGES)
        dotsLayout.removeAllViews()

        for (i in 0 until NUM_PAGES) {
            dots[i] = ImageView(this)
            dots[i]?.setImageResource(R.drawable.inactive_dot)
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(8, 0, 8, 0)
            dotsLayout.addView(dots[i], params)
        }

        if (dots.isNotEmpty()) {
            dots[0]?.setImageResource(R.drawable.active_dot)
        }

    }

    private val viewListener = object : ViewPager.OnPageChangeListener {
        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
        ) {
        }

        override fun onPageSelected(position: Int) {
            for (i in dots.indices) {
                dots[i]?.setImageResource(R.drawable.inactive_dot)
            }
            dots[position]?.setImageResource(R.drawable.active_dot)
        }

        override fun onPageScrollStateChanged(state: Int) {}
    }
}
