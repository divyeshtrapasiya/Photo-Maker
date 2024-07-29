package com.example.photoeditor.beautycamera.collagemaker.Freesytle_Activity

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.AdapterView
import android.widget.GridView
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.photoeditor.beautycamera.collagemaker.Freestyle_Gallery_Adapter
import com.example.photoeditor.beautycamera.collagemaker.Freestyle_Selected_Adapter
import com.example.photoeditor.beautycamera.collagemaker.R
import com.example.photoeditor.beautycamera.collagemaker.databinding.ActivityFreestyleImageSelectBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.ByteArrayOutputStream
import java.util.UUID

class Freestyle_Image_Select_Activity : AppCompatActivity() {

    lateinit var binding: ActivityFreestyleImageSelectBinding

    private lateinit var progressBar: ProgressBar
    private val imageList = arrayListOf<Uri>()
    private val selectedImagesList = arrayListOf<Uri>()
    private lateinit var adapter: Freestyle_Gallery_Adapter
    private lateinit var selectedImagesAdapter: Freestyle_Selected_Adapter

    companion object {
        const val TAG = "CollageImageSelect"
        const val REQUEST_PERMISSIONS_CODE = 1
        const val REQUEST_CAMERA_CODE = 2
        const val EXTRA_SELECTED_IMAGES = "com.example.photoeditor.beautycamera.collagemaker.SELECTED_IMAGES"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityFreestyleImageSelectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        progressBar = findViewById(R.id.progress_bar)

        initView()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initView() {
        binding.backButton.setOnClickListener {
            onBackPressed()
        }

        val galleryGrid: GridView = findViewById(R.id.gallery_grid)
        adapter = Freestyle_Gallery_Adapter(this, imageList)
        galleryGrid.adapter = adapter

        galleryGrid.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            if (position == 0) {
                openCamera()
            } else {
                val selectedUri = imageList[position]
                if (!selectedImagesList.contains(selectedUri)) {
                    selectedImagesList.add(selectedUri)
                    selectedImagesAdapter.notifyDataSetChanged()
                }
            }
        }

        if (arePermissionsGranted()) {
            loadImagesFromGallery()
        } else {
            requestPermissions()
        }

        val selectedImagesRecyclerView: RecyclerView = findViewById(R.id.selected_image_recycler_view)
        selectedImagesAdapter = Freestyle_Selected_Adapter(this, selectedImagesList)
        selectedImagesRecyclerView.adapter = selectedImagesAdapter
        selectedImagesRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        binding.relativeNextButton.setOnClickListener {
            goToNextActivity()
        }
    }

    @SuppressLint("QueryPermissionsNeeded")
    private fun openCamera() {
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (cameraIntent.resolveActivity(packageManager) != null) {
            startActivityForResult(cameraIntent, REQUEST_CAMERA_CODE)
        }
    }

    private fun loadImagesFromGallery() {
        progressBar.visibility = View.VISIBLE

        CoroutineScope(Dispatchers.IO).launch {
            val imageUris = getImageUris()
            withContext(Dispatchers.Main) {
                progressBar.visibility = View.GONE
                imageList.addAll(imageUris)
                adapter.notifyDataSetChanged()
            }
        }
    }

    private fun getImageUris(): List<Uri> {
        val uriList = mutableListOf<Uri>()
        val projection = arrayOf(MediaStore.Images.Media._ID)
        val sortOrder = "${MediaStore.Images.Media.DATE_ADDED} DESC"
        val query = contentResolver.query(
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
            projection,
            null,
            null,
            sortOrder
        )

        query?.use { cursor ->
            val idColumn = cursor.getColumnIndexOrThrow(MediaStore.Images.Media._ID)
            while (cursor.moveToNext()) {
                val id = cursor.getLong(idColumn)
                val uri = Uri.withAppendedPath(
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                    id.toString()
                )
                uriList.add(uri)
            }
        }
        return uriList
    }

    private fun arePermissionsGranted(): Boolean {
        val permissions = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)
        } else {
            arrayOf(
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            )
        }
        return permissions.all {
            ContextCompat.checkSelfPermission(this, it) == PackageManager.PERMISSION_GRANTED
        }
    }

    private fun requestPermissions() {
        val permissions = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)
        } else {
            arrayOf(
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            )
        }
        ActivityCompat.requestPermissions(this, permissions, REQUEST_PERMISSIONS_CODE)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<out String>, grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_PERMISSIONS_CODE) {
            if (grantResults.all { it == PackageManager.PERMISSION_GRANTED }) {
                loadImagesFromGallery()
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CAMERA_CODE && resultCode == RESULT_OK) {
            val extras = data?.extras
            val imageBitmap = extras?.get("data") as Bitmap
            val imageUri = getImageUriFromBitmap(imageBitmap)
            if (imageUri != null) {
                imageList.add(0, imageUri)
                adapter.notifyDataSetChanged()
                selectedImagesList.add(0, imageUri)
                selectedImagesAdapter.notifyDataSetChanged()
            }
        }
    }

    private fun getImageUriFromBitmap(bitmap: Bitmap): Uri? {
        val bytes = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes)
        val path = MediaStore.Images.Media.insertImage(contentResolver, bitmap, UUID.randomUUID().toString() + ".jpeg", "drawing")
        return Uri.parse(path)
    }

    private fun goToNextActivity() {

        val selectedImageUris = ArrayList(selectedImagesList.map { it.toString() })

        val intent = Intent(this, Freestyle_Background_Activity::class.java).apply {
            putStringArrayListExtra(EXTRA_SELECTED_IMAGES, selectedImageUris)
        }
        startActivity(intent)
    }
}
