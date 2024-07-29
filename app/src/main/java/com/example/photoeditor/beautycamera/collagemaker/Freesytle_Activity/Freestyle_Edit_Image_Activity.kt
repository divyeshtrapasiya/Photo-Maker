package com.example.photoeditor.beautycamera.collagemaker.Freesytle_Activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.photoeditor.beautycamera.collagemaker.Collage_Activity.Collage_Drow_Activity
import com.example.photoeditor.beautycamera.collagemaker.databinding.ActivityFreestyleEditImageBinding

class Freestyle_Edit_Image_Activity : AppCompatActivity() {

    lateinit var binding: ActivityFreestyleEditImageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFreestyleEditImageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initview()

    }

    private fun initview() {

        binding.relativeFreame.setOnClickListener {

            val intent = Intent(this, Freestyle_Frame_Activity::class.java)
            startActivity(intent)

        }

        binding.relativeText.setOnClickListener {

            val intent = Intent(this, Freestyle_Text_Activity::class.java)
            startActivity(intent)

        }


        binding.relativeFilter.setOnClickListener {

            val intent = Intent(this, Freestyle_Filter_Activity::class.java)
            startActivity(intent)

        }

        binding.relativeAdd.setOnClickListener {

            val intent = Intent(this, Freestyle_Add_Image_Activity::class.java)
            startActivity(intent)

        }

        binding.relativeBackground.setOnClickListener {

            val intent = Intent(this, Freestyle_Background_Activity::class.java)
            startActivity(intent)

        }

        binding.relativeStiker.setOnClickListener {

            val intent = Intent(this, Freestyle_Stiker_Activity::class.java)
            startActivity(intent)

        }

        binding.relativeDrow.setOnClickListener {

            val intent = Intent(this, Freestyle_Drow_Activity::class.java)
            startActivity(intent)

        }
    }
}