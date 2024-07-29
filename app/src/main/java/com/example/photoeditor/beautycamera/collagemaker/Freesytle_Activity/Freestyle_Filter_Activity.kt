package com.example.photoeditor.beautycamera.collagemaker.Freesytle_Activity

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.photoeditor.beautycamera.collagemaker.R
import com.example.photoeditor.beautycamera.collagemaker.databinding.ActivityFreestyleFilterBinding

class Freestyle_Filter_Activity : AppCompatActivity() {

    lateinit var binding: ActivityFreestyleFilterBinding
    private var isFilterSectionVisible: Boolean = false
    private var isAdjustSectionVisible: Boolean = false

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFreestyleFilterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initview()

    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun initview() {

        binding.filterSection.visibility = View.VISIBLE
        binding.adjustSection.visibility = View.GONE

        updateButtonStates(binding.filterIcon)

        binding.filterIcon.setOnClickListener {
            if (!isFilterSectionVisible) {
                binding.filterSection.visibility = View.VISIBLE
                binding.adjustSection.visibility = View.GONE
                isFilterSectionVisible = true
                isAdjustSectionVisible = false
                updateButtonStates(binding.filterIcon)
            }
        }

        binding.adjustIcon.setOnClickListener {
            if (!isAdjustSectionVisible) {
                binding.adjustSection.visibility = View.VISIBLE
                binding.filterSection.visibility = View.GONE
                isAdjustSectionVisible = true
                isFilterSectionVisible = false
                updateButtonStates(binding.adjustIcon)
            }
        }

        binding.seekbar.max = 100
        binding.seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            @SuppressLint("SetTextI18n")
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                binding.seekbarText.text = "${progress - 50}" // Adjusted to center at 0
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun updateButtonStates(selectedButton: View) {
        binding.filterIcon.setBackgroundResource(
            if (selectedButton == binding.filterIcon)
                R.drawable.button_background_selected
            else
                R.drawable.button_background_unselected
        )
        binding.adjustIcon.setBackgroundResource(
            if (selectedButton == binding.adjustIcon)
                R.drawable.button_background_selected
            else
                R.drawable.button_background_unselected
        )

        binding.textFilter.isSelected = (selectedButton == binding.filterIcon)
        binding.textFilter.setTextColor(
            if (selectedButton == binding.filterIcon)
                getColor(R.color.selected_text_color)
            else
                getColor(R.color.unselected_text_color)
        )

        binding.textAdjust.isSelected = (selectedButton == binding.adjustIcon)
        binding.textAdjust.setTextColor(
            if (selectedButton == binding.adjustIcon)
                getColor(R.color.selected_text_color)
            else
                getColor(R.color.unselected_text_color)
        )
    }

}