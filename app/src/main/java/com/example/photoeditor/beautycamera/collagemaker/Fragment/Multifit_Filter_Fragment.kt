package com.example.photoeditor.beautycamera.collagemaker.Fragment

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import com.example.photoeditor.beautycamera.collagemaker.R
import com.example.photoeditor.beautycamera.collagemaker.databinding.FragmentMultifitFilterBinding

class Multifit_Filter_Fragment : Fragment() {

    private lateinit var binding: FragmentMultifitFilterBinding
    private var isFilterSectionVisible: Boolean = false
    private var isAdjustSectionVisible: Boolean = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentMultifitFilterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {

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

    }

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
                ContextCompat.getColor(requireContext(), R.color.selected_text_color)
            else
                ContextCompat.getColor(requireContext(), R.color.unselected_text_color)
        )

        binding.textAdjust.isSelected = (selectedButton == binding.adjustIcon)
        binding.textAdjust.setTextColor(
            if (selectedButton == binding.adjustIcon)
                ContextCompat.getColor(requireContext(), R.color.selected_text_color)
            else
                ContextCompat.getColor(requireContext(), R.color.unselected_text_color)
        )
    }
}
