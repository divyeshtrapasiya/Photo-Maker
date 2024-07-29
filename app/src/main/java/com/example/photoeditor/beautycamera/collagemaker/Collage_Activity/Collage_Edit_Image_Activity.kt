package com.example.photoeditor.beautycamera.collagemaker.Collage_Activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.photoeditor.beautycamera.collagemaker.Edit_Activity.Edit_Stiker_Activity
import com.example.photoeditor.beautycamera.collagemaker.R
import com.example.photoeditor.beautycamera.collagemaker.databinding.ActivityCollageEditImageBinding

class Collage_Edit_Image_Activity : AppCompatActivity() {

    lateinit var binding : ActivityCollageEditImageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCollageEditImageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initview()

    }

    private fun initview() {


        binding.relativeFreame.setOnClickListener {

            val intent = Intent(this, Collage_Frame_Activity::class.java)
            startActivity(intent)

        }

        binding.relativeText.setOnClickListener {

            val intent = Intent(this, Collage_Edit_Text_Activity::class.java)
            startActivity(intent)

        }


        binding.relativeFilter.setOnClickListener {

            val intent = Intent(this, Collage_Filter_Activity::class.java)
            startActivity(intent)

        }

        binding.relativeAdd.setOnClickListener {

            val intent = Intent(this, Collage_Filter_Activity::class.java)
            startActivity(intent)

        }

        binding.relativeBackground.setOnClickListener {

            val intent = Intent(this, Collage_Image_Background_Activity::class.java)
            startActivity(intent)

        }

        binding.relativeStiker.setOnClickListener {

            val intent = Intent(this, Collage_Stiker_Activity::class.java)
            startActivity(intent)

        }

        binding.relativeDrow.setOnClickListener {

            val intent = Intent(this, Collage_Drow_Activity::class.java)
            startActivity(intent)

        }


    }

}