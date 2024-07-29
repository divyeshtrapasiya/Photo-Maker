package com.example.photoeditor.beautycamera.collagemaker.Class

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatSeekBar

class CenteredSeekBar : AppCompatSeekBar {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // Adjust thumb position to center at 0 percent
        val thumb = thumb
        val thumbWidth = thumb.intrinsicWidth
        val thumbOffset = thumbWidth / 2f
        val thumbX = thumbOffset + (width - thumbWidth) * progress / max.toFloat()

        canvas.apply {
            save()
            translate(thumbX, 0f)
            thumb.draw(this)
            restore()
        }
    }

    override fun setMax(max: Int) {
        super.setMax(max)
        progress = max / 2 // Center the thumb at 0 percent initially
    }
}
