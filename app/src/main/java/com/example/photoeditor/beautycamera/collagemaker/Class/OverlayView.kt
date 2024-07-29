package com.example.photoeditor.beautycamera.collagemaker.Class

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.os.Handler
import android.os.Looper
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewTreeObserver

class OverlayView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr), ViewTreeObserver.OnGlobalLayoutListener {

    private val fillPaint = Paint().apply {
        color = 0x660000FF // Blue color with transparency
        style = Paint.Style.FILL
    }

    private val strokePaint = Paint().apply {
        color = 0xFFFFFFFF.toInt() // White color for stroke
        style = Paint.Style.STROKE
        strokeWidth = 4f // Default stroke width
    }

    private val pathPaint = Paint().apply {
        color = 0x660000FF // Blue color for path
        style = Paint.Style.STROKE
        strokeWidth = 60f // Default stroke width
    }

    private var circleRadius = 50f
    private var circleX = 0f
    private var circleY = 0f
    var offsetX = 0f
    var offsetY = 0f

    private val pathStack = mutableListOf<Path>()
    private val undonePaths = mutableListOf<Path>()
    private var currentPath = Path()
    private var isTouching = false

    private val handler = Handler(Looper.getMainLooper())
    private val removePathRunnable = Runnable {
        removeLastPath()
    }

    private var imageBitmap: Bitmap? = null
    private var maskBitmap: Bitmap? = null
    private var imageCanvas: Canvas? = null
    private var maskCanvas: Canvas? = null

    init {
        // Add a global layout listener to initialize bitmaps when view is laid out
        viewTreeObserver.addOnGlobalLayoutListener(this)
    }

    private fun setupBitmaps() {
        if (width > 0 && height > 0) {
            imageBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
            maskBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
            imageCanvas = Canvas(imageBitmap!!)
            maskCanvas = Canvas(maskBitmap!!)
            // Fill mask with white to start (fully opaque)
            maskCanvas?.drawColor(Color.WHITE)
        }
    }

    fun setImageBitmap(bitmap: Bitmap) {
        if (width > 0 && height > 0) {
            imageBitmap = Bitmap.createScaledBitmap(bitmap, width, height, false)
            imageCanvas = Canvas(imageBitmap!!)
            invalidate()
        } else {
            // If view is not laid out yet, wait until it is
            viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
                override fun onGlobalLayout() {
                    if (width > 0 && height > 0) {
                        imageBitmap = Bitmap.createScaledBitmap(bitmap, width, height, false)
                        imageCanvas = Canvas(imageBitmap!!)
                        invalidate()
                        viewTreeObserver.removeOnGlobalLayoutListener(this)
                    }
                }
            })
        }
    }

    fun setCircleRadius(radius: Float) {
        circleRadius = radius
        invalidate()
    }

    fun setOffsets(offsetX: Float, offsetY: Float) {
        this.offsetX = offsetX
        this.offsetY = offsetY
        invalidate()
    }

    fun setStrokeWidth(width: Float) {
        pathPaint.strokeWidth = width
        strokePaint.strokeWidth = width
        invalidate()
    }

    private fun removeLastPath() {
        if (pathStack.isNotEmpty()) {
            pathStack.removeAt(pathStack.lastIndex)
            invalidate()
        }
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // Draw the image
        imageBitmap?.let {
            canvas.drawBitmap(it, 0f, 0f, null)
        }



        // Draw circle with applied offset
        val centerX = circleX + offsetX
        val centerY = circleY + offsetY
        canvas.drawCircle(centerX, centerY, circleRadius, fillPaint)
        canvas.drawCircle(centerX, centerY, circleRadius, strokePaint)

        // Draw all paths
        for (path in pathStack) {
            canvas.drawPath(path, pathPaint)
        }

        // Draw user-interactive blue path if touching
        if (isTouching) {
            canvas.drawPath(currentPath, pathPaint)
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                currentPath = Path()
                currentPath.moveTo(event.x, event.y)
                circleX = event.x
                circleY = event.y
                isTouching = true
                invalidate()
                // Schedule path removal after 3 seconds
                handler.postDelayed(removePathRunnable, 3000)
            }
            MotionEvent.ACTION_MOVE -> {
                currentPath.lineTo(event.x, event.y)
                circleX = event.x
                circleY = event.y
                invalidate()
            }
            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                pathStack.add(currentPath)
                maskCanvas?.drawPath(currentPath, pathPaint)
                undonePaths.clear()
                isTouching = false
                invalidate()
            }
        }
        return true
    }

    override fun onSizeChanged(width: Int, height: Int, oldWidth: Int, oldHeight: Int) {
        super.onSizeChanged(width, height, oldWidth, oldHeight)
        // Recalculate circle's initial position based on the new size
        circleX = width / 2f
        circleY = height / 2f
        setupBitmaps()
    }

    override fun onGlobalLayout() {
        if (width > 0 && height > 0) {
            setupBitmaps()
            viewTreeObserver.removeOnGlobalLayoutListener(this)
        }
    }
}
