package com.example.photoeditor.beautycamera.collagemaker.Template_Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.photoeditor.beautycamera.collagemaker.Adaptor.TemplateAdapter
import com.example.photoeditor.beautycamera.collagemaker.Class.OkHttpHelper
import com.example.photoeditor.beautycamera.collagemaker.Model.TemplateApi
import com.example.photoeditor.beautycamera.collagemaker.databinding.FragmentAllTemplatesBinding

class All_Templates : Fragment() {

    private lateinit var binding: FragmentAllTemplatesBinding
    private lateinit var adapter: TemplateAdapter
    private var allTemplates: List<String> = listOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentAllTemplatesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        binding.recycleview.layoutManager = GridLayoutManager(requireContext(), 2)

        adapter = TemplateAdapter(requireContext(), mutableListOf(), onItemClick)
        binding.recycleview.adapter = adapter

        val url =
            "https://s3.eu-north-1.amazonaws.com/photoeditorbeautycamera.com/photoeditor/templates.json"

        OkHttpHelper.fetchTemplates(url) { templateApi ->
            templateApi?.let {
                allTemplates = extractImageUrls(templateApi)
                requireActivity().runOnUiThread {
                    adapter.updateData(allTemplates)
                }
            } ?: run {
                // Handle error scenario
            }
        }

        setupCategoryFilters()
    }

    private fun extractImageUrls(templateApi: TemplateApi): List<String> {
        return templateApi.templates.flatMap { templateItem ->
            listOfNotNull(


                // Summer templates
                templateItem?.summer?.group1?.imageUrl,
                templateItem?.summer?.group2?.imageUrl,
                templateItem?.summer?.group3?.imageUrl,
                templateItem?.summer?.group4?.imageUrl,
                templateItem?.summer?.group5?.imageUrl,
                templateItem?.summer?.group6?.imageUrl,
                templateItem?.summer?.group7?.imageUrl,
                templateItem?.summer?.group8?.imageUrl,
                templateItem?.summer?.group9?.imageUrl,
                templateItem?.summer?.group10?.imageUrl,
                templateItem?.summer?.group11?.imageUrl,
                templateItem?.summer?.group12?.imageUrl,
                templateItem?.summer?.group13?.imageUrl,
                templateItem?.summer?.group14?.imageUrl,
                templateItem?.summer?.group15?.imageUrl,
                templateItem?.summer?.group16?.imageUrl,
                templateItem?.summer?.group17?.imageUrl,
                templateItem?.summer?.group18?.imageUrl,

                // School templates
                templateItem?.school?.group1?.imageUrl,
                templateItem?.school?.group2?.imageUrl,
                templateItem?.school?.group3?.imageUrl,
                templateItem?.school?.group4?.imageUrl,
                templateItem?.school?.group5?.imageUrl,
                templateItem?.school?.group6?.imageUrl,
                templateItem?.school?.group7?.imageUrl,
                templateItem?.school?.group8?.imageUrl,
                templateItem?.school?.group9?.imageUrl,
                templateItem?.school?.group10?.imageUrl,
                templateItem?.school?.group11?.imageUrl,
                templateItem?.school?.group12?.imageUrl,
                templateItem?.school?.group13?.imageUrl,
                templateItem?.school?.group14?.imageUrl,
                templateItem?.school?.group15?.imageUrl,
                templateItem?.school?.group16?.imageUrl,
                templateItem?.school?.group17?.imageUrl,
                templateItem?.school?.group18?.imageUrl,
                templateItem?.school?.group19?.imageUrl,


                // Childhood templates
                templateItem?.childhood?.group1?.imageUrl,
                templateItem?.childhood?.group2?.imageUrl,
                templateItem?.childhood?.group3?.imageUrl,
                templateItem?.childhood?.group4?.imageUrl,
                templateItem?.childhood?.group5?.imageUrl,
                templateItem?.childhood?.group6?.imageUrl,
                templateItem?.childhood?.group7?.imageUrl,
                templateItem?.childhood?.group8?.imageUrl,
                templateItem?.childhood?.group9?.imageUrl,
                templateItem?.childhood?.group10?.imageUrl,
                templateItem?.childhood?.group11?.imageUrl,
                templateItem?.childhood?.group12?.imageUrl,
                templateItem?.childhood?.group13?.imageUrl,
                templateItem?.childhood?.group14?.imageUrl,
                templateItem?.childhood?.group15?.imageUrl,
                templateItem?.childhood?.group16?.imageUrl,
                templateItem?.childhood?.group17?.imageUrl,
                templateItem?.childhood?.group18?.imageUrl,
                templateItem?.childhood?.group19?.imageUrl,
                templateItem?.childhood?.group20?.imageUrl,

                // Birthday templates
                templateItem?.birthday?.group1?.imageUrl,
                templateItem?.birthday?.group2?.imageUrl,
                templateItem?.birthday?.group3?.imageUrl,
                templateItem?.birthday?.group4?.imageUrl,
                templateItem?.birthday?.group5?.imageUrl,
                templateItem?.birthday?.group6?.imageUrl,
                templateItem?.birthday?.group7?.imageUrl,
                templateItem?.birthday?.group8?.imageUrl,
                templateItem?.birthday?.group9?.imageUrl,
                templateItem?.birthday?.group10?.imageUrl,
                templateItem?.birthday?.group11?.imageUrl,
                templateItem?.birthday?.group12?.imageUrl,
                templateItem?.birthday?.group13?.imageUrl,
                templateItem?.birthday?.group14?.imageUrl,
                templateItem?.birthday?.group15?.imageUrl,
                templateItem?.birthday?.group16?.imageUrl,
                templateItem?.birthday?.group17?.imageUrl,
                templateItem?.birthday?.group18?.imageUrl,
                templateItem?.birthday?.group19?.imageUrl,

                // Love templates
                templateItem?.love?.group1?.imageUrl,
                templateItem?.love?.group2?.imageUrl,
                templateItem?.love?.group3?.imageUrl,
                templateItem?.love?.group4?.imageUrl,
                templateItem?.love?.group5?.imageUrl,
                templateItem?.love?.group6?.imageUrl,
                templateItem?.love?.group7?.imageUrl,
                templateItem?.love?.group8?.imageUrl,
                templateItem?.love?.group9?.imageUrl,
                templateItem?.love?.group10?.imageUrl,
                templateItem?.love?.group11?.imageUrl,
                templateItem?.love?.group12?.imageUrl,
                templateItem?.love?.group13?.imageUrl,
                templateItem?.love?.group14?.imageUrl,
                templateItem?.love?.group15?.imageUrl,
                templateItem?.love?.group16?.imageUrl,
                templateItem?.love?.group17?.imageUrl,
                templateItem?.love?.group18?.imageUrl,
                templateItem?.love?.group19?.imageUrl,

                // Selfie templates
                templateItem?.selfie?.group1?.imageUrl,
                templateItem?.selfie?.group2?.imageUrl,
                templateItem?.selfie?.group3?.imageUrl,
                templateItem?.selfie?.group4?.imageUrl,
                templateItem?.selfie?.group5?.imageUrl,
                templateItem?.selfie?.group6?.imageUrl,
                templateItem?.selfie?.group7?.imageUrl,
                templateItem?.selfie?.group8?.imageUrl,
                templateItem?.selfie?.group9?.imageUrl,
                templateItem?.selfie?.group10?.imageUrl,
                templateItem?.selfie?.group11?.imageUrl,
                templateItem?.selfie?.group12?.imageUrl,
                templateItem?.selfie?.group13?.imageUrl,
                templateItem?.selfie?.group14?.imageUrl,
                templateItem?.selfie?.group15?.imageUrl,
                templateItem?.selfie?.group16?.imageUrl,
                templateItem?.selfie?.group17?.imageUrl,
                templateItem?.selfie?.group18?.imageUrl,
                templateItem?.selfie?.group19?.imageUrl,
                templateItem?.selfie?.group20?.imageUrl,

                // LG Story templates
                templateItem?.lgStory?.group1?.imageUrl,
                templateItem?.lgStory?.group2?.imageUrl,
                templateItem?.lgStory?.group3?.imageUrl,
                templateItem?.lgStory?.group4?.imageUrl,
                templateItem?.lgStory?.group5?.imageUrl,
                templateItem?.lgStory?.group6?.imageUrl,
                templateItem?.lgStory?.group7?.imageUrl,
                templateItem?.lgStory?.group8?.imageUrl,
                templateItem?.lgStory?.group9?.imageUrl,
                templateItem?.lgStory?.group10?.imageUrl,
                templateItem?.lgStory?.group11?.imageUrl,
                templateItem?.lgStory?.group12?.imageUrl,
                templateItem?.lgStory?.group13?.imageUrl,
                templateItem?.lgStory?.group14?.imageUrl,
                templateItem?.lgStory?.group15?.imageUrl,
                templateItem?.lgStory?.group16?.imageUrl,
                templateItem?.lgStory?.group17?.imageUrl,
                templateItem?.lgStory?.group18?.imageUrl,
                templateItem?.lgStory?.group19?.imageUrl,
                templateItem?.lgStory?.group20?.imageUrl,


                // Pride Month templates
                templateItem?.pridemonth?.group1?.imageUrl,
                templateItem?.pridemonth?.group2?.imageUrl,
                templateItem?.pridemonth?.group3?.imageUrl,
                templateItem?.pridemonth?.group4?.imageUrl,
                templateItem?.pridemonth?.group5?.imageUrl,
                templateItem?.pridemonth?.group6?.imageUrl,
                templateItem?.pridemonth?.group7?.imageUrl,
                templateItem?.pridemonth?.group8?.imageUrl,
                templateItem?.pridemonth?.group9?.imageUrl,
                templateItem?.pridemonth?.group10?.imageUrl,
                templateItem?.pridemonth?.group11?.imageUrl,
                templateItem?.pridemonth?.group12?.imageUrl,
                templateItem?.pridemonth?.group13?.imageUrl,
                templateItem?.pridemonth?.group14?.imageUrl,
                templateItem?.pridemonth?.group15?.imageUrl,
                templateItem?.pridemonth?.group16?.imageUrl,
                templateItem?.pridemonth?.group17?.imageUrl,
                templateItem?.pridemonth?.group18?.imageUrl,
                templateItem?.pridemonth?.group19?.imageUrl,


                // Frame templates
                templateItem?.frame?.group1?.imageUrl,
                templateItem?.frame?.group2?.imageUrl,
                templateItem?.frame?.group3?.imageUrl,
                templateItem?.frame?.group4?.imageUrl,
                templateItem?.frame?.group5?.imageUrl,
                templateItem?.frame?.group6?.imageUrl,
                templateItem?.frame?.group7?.imageUrl,
                templateItem?.frame?.group8?.imageUrl,
                templateItem?.frame?.group9?.imageUrl,
                templateItem?.frame?.group10?.imageUrl,
                templateItem?.frame?.group11?.imageUrl,
                templateItem?.frame?.group12?.imageUrl,
                templateItem?.frame?.group13?.imageUrl,
                templateItem?.frame?.group14?.imageUrl,
                templateItem?.frame?.group15?.imageUrl,
                templateItem?.frame?.group16?.imageUrl,
                templateItem?.frame?.group17?.imageUrl,
                templateItem?.frame?.group18?.imageUrl,
                templateItem?.frame?.group19?.imageUrl,
                templateItem?.frame?.group20?.imageUrl

            )
        }
    }

    private fun setupCategoryFilters() {

        binding.allCategory.setOnClickListener { filterTemplates("All") }
        binding.summerCategory.setOnClickListener { filterTemplates("Summer") }
        binding.schoolCategory.setOnClickListener { filterTemplates("School") }
        binding.childhoodCategory.setOnClickListener { filterTemplates("Childhood") }
        binding.birthdayCategory.setOnClickListener { filterTemplates("Birthday") }
        binding.LoveCategory.setOnClickListener { filterTemplates("Love") }
        binding.selfieCategory.setOnClickListener { filterTemplates("Selfie") }
        binding.IgstoryCategory.setOnClickListener { filterTemplates("IG Story")}
        binding.PridemonthCategory.setOnClickListener { filterTemplates("Pride Month")}
        binding.FrameCategory.setOnClickListener { filterTemplates("Frame") }
    }

    private fun filterTemplates(category: String) {
        val filteredTemplates = if (category == "All") {
            allTemplates
        } else {
            allTemplates.filter { it.contains(category, ignoreCase = true) }
        }
        adapter.updateData(filteredTemplates)
    }

    private val onItemClick: (String) -> Unit = { imageUrl ->

    }
}

