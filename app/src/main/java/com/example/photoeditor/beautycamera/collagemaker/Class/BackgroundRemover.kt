package com.example.photoeditor.beautycamera.collagemaker.Class

import android.content.Context
import android.graphics.Bitmap
import org.tensorflow.lite.Interpreter
import org.tensorflow.lite.support.image.TensorImage
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import java.nio.ByteBuffer
import java.nio.ByteOrder

class BackgroundRemover(private val context: Context) {

    private val interpreter: Interpreter

    init {
        // Load the TFLite model from assets
        val modelFile = loadModelFile("model.tflite")
        interpreter = Interpreter(modelFile)
    }

    private fun loadModelFile(fileName: String): ByteBuffer {
        val assetFileDescriptor = context.assets.openFd(fileName)
        val inputStream = assetFileDescriptor.createInputStream()
        val byteArray = ByteArray(assetFileDescriptor.length.toInt())
        inputStream.read(byteArray)
        inputStream.close()

        val byteBuffer = ByteBuffer.allocateDirect(byteArray.size)
        byteBuffer.order(ByteOrder.nativeOrder())
        byteBuffer.put(byteArray)
        return byteBuffer
    }

    fun removeBackground(bitmap: Bitmap): Bitmap {
        // Prepare input tensor
        val inputImage = TensorImage.fromBitmap(bitmap)

        // Run inference
        val outputBuffer = TensorBuffer.createFixedSize(intArrayOf(1, bitmap.height, bitmap.width, 1), org.tensorflow.lite.DataType.FLOAT32)
        interpreter.run(inputImage.buffer, outputBuffer.buffer)

        // Process the output to remove the background
        val outputBitmap = processOutput(bitmap, outputBuffer.floatArray)
        return outputBitmap
    }

    private fun processOutput(originalBitmap: Bitmap, output: FloatArray): Bitmap {
        val width = originalBitmap.width
        val height = originalBitmap.height
        val resultBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)

        for (y in 0 until height) {
            for (x in 0 until width) {
                val alpha = (output[y * width + x] * 255).toInt()
                val pixel = originalBitmap.getPixel(x, y)
                val newPixel = (pixel and 0x00FFFFFF) or (alpha shl 24)
                resultBitmap.setPixel(x, y, newPixel)
            }
        }
        return resultBitmap
    }
}
