package com.example.photoeditor.beautycamera.collagemaker.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.photoeditor.beautycamera.collagemaker.R
import com.example.photoeditor.beautycamera.collagemaker.databinding.FragmentMultifitBackgroundBinding

class Multifit_Background_Fragment : Fragment() {

    private lateinit var binding: FragmentMultifitBackgroundBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentMultifitBackgroundBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        binding.linearFilter.setOnClickListener {
            findNavController().navigate(R.id.action_multifit_Background_Fragment_to_multifit_Filter_Fragment)
        }
    }
}
