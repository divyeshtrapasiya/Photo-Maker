package com.example.photoeditor.beautycamera.collagemaker.Collage_Activity

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.photoeditor.beautycamera.collagemaker.Adaptor.CollageAddImageAdapter
import com.example.photoeditor.beautycamera.collagemaker.Adaptor.EditImageGridAdapter
import com.example.photoeditor.beautycamera.collagemaker.Edit_Activity.Edit_Gallery_image_Activity
import com.example.photoeditor.beautycamera.collagemaker.Edit_Activity.Edit_Gallery_image_Activity.Companion
import com.example.photoeditor.beautycamera.collagemaker.Edit_Activity.Edit_Image_Activity
import com.example.photoeditor.beautycamera.collagemaker.R
import com.example.photoeditor.beautycamera.collagemaker.databinding.ActivityCollageAddImageBinding
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.ArrayList
import java.util.Date
import java.util.Locale

class Collage_Add_Image_Activity : AppCompatActivity() {

    lateinit var binding : ActivityCollageAddImageBinding
    private lateinit var imageUris: ArrayList<Uri>
    private lateinit var adapter: CollageAddImageAdapter
    private var cameraPhotoUri: Uri? = null

    companion object {
        const val REQUEST_CODE_READ_EXTERNAL_STORAGE = 100
        const val REQUEST_CODE_CAMERA = 101
        const val TAG = "EditGalleryImageActivity"
        const val EXTRA_IMAGE_URI =
            "com.example.photoeditor.beautycamera.collagemaker.IMAGE_URI"
        var currentPhotoPath: String? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCollageAddImageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        imageUris = ArrayList()
        adapter = CollageAddImageAdapter(this, imageUris, { uri ->
            openEditImageActivity(uri)
        },{
            openCamera()
        })

        binding.galleryGrid.layoutManager = GridLayoutManager(this, 4)
        binding.galleryGrid.adapter = adapter

        binding.backButton.setOnClickListener {
            onBackPressed()
        }

        if (isPermissionGranted()) {
            loadImagesFromGallery()
        } else {
            requestPermission()
        }
    }

    @SuppressLint("LongLogTag")
    private fun isPermissionGranted(): Boolean {
        val granted = ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.READ_EXTERNAL_STORAGE
        ) == PackageManager.PERMISSION_GRANTED
        Log.d(Edit_Gallery_image_Activity.TAG, "Permission granted: $granted")
        return granted
    }

    @SuppressLint("LongLogTag")
    private fun requestPermission() {
        Log.d(Edit_Gallery_image_Activity.TAG, "Requesting permission")
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
            Edit_Gallery_image_Activity.REQUEST_CODE_READ_EXTERNAL_STORAGE
        )
    }

    @SuppressLint("LongLogTag")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        Log.d(Edit_Gallery_image_Activity.TAG, "onRequestPermissionsResult called")
        if (requestCode == Edit_Gallery_image_Activity.REQUEST_CODE_READ_EXTERNAL_STORAGE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Log.d(Edit_Gallery_image_Activity.TAG, "Permission granted")
                loadImagesFromGallery()
            } else {
                Log.d(Edit_Gallery_image_Activity.TAG, "Permission denied")
                Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged", "LongLogTag")
    private fun loadImagesFromGallery() {
        Log.d(Edit_Gallery_image_Activity.TAG, "Loading images from gallery")
        val projection = arrayOf(
            MediaStore.Images.Media._ID,
            MediaStore.Images.Media.DISPLAY_NAME,
            MediaStore.Images.Media.DATE_ADDED,
            MediaStore.Images.Media.DATE_MODIFIED
        )

        val sortOrder = "${MediaStore.Images.Media.DATE_MODIFIED} DESC"
        val queryUri: Uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI

        contentResolver.query(queryUri, projection, null, null, sortOrder)?.use { cursor ->
            val idColumn = cursor.getColumnIndexOrThrow(MediaStore.Images.Media._ID)

            while (cursor.moveToNext()) {
                val id = cursor.getLong(idColumn)
                val uri = Uri.withAppendedPath(queryUri, id.toString())
                imageUris.add(uri)
            }
        }

        adapter.notifyDataSetChanged()
    }

    private fun openEditImageActivity(uri: Uri) {
        val intent = Intent(this, Edit_Image_Activity::class.java).apply {
            putExtra(Edit_Gallery_image_Activity.EXTRA_IMAGE_URI, uri.toString())
        }
        startActivity(intent)
    }

    @SuppressLint("LongLogTag")
    private fun openCamera() {
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (cameraIntent.resolveActivity(packageManager) != null) {
            val photoFile: File? = try {
                createImageFile()
            } catch (ex: IOException) {
                Log.e(Edit_Gallery_image_Activity.TAG, "Error occurred while creating the file", ex)
                null
            }
            photoFile?.also {
                cameraPhotoUri = FileProvider.getUriForFile(
                    this,
                    "${applicationContext.packageName}.fileprovider",
                    it
                )
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, cameraPhotoUri)
                startActivityForResult(cameraIntent,
                    Edit_Gallery_image_Activity.REQUEST_CODE_CAMERA
                )
            }
        }
    }

    @Throws(IOException::class)
    private fun createImageFile(): File {
        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(Date())
        val storageDir: File = getExternalFilesDir(Environment.DIRECTORY_PICTURES)!!
        return File.createTempFile(
            "JPEG_${timeStamp}_",
            ".jpg",
            storageDir
        ).apply {
            Edit_Gallery_image_Activity.currentPhotoPath = absolutePath
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == Edit_Gallery_image_Activity.REQUEST_CODE_CAMERA && resultCode == RESULT_OK) {
            cameraPhotoUri?.let {
                imageUris.add(0, it)
                adapter.notifyDataSetChanged()
            }
        }
    }
}
