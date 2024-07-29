package com.example.photoeditor.beautycamera.collagemaker.Class

import jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter
import android.opengl.GLES20

class GPUImageNoiseFilter : GPUImageFilter(NO_FILTER_VERTEX_SHADER, NOISE_FRAGMENT_SHADER) {

    companion object {
        private const val NOISE_FRAGMENT_SHADER = """
            precision mediump float;
            varying vec2 textureCoordinate;
            uniform sampler2D inputImageTexture;
            uniform float intensity;

            float rand(vec2 co) {
                return fract(sin(dot(co.xy, vec2(12.9898, 78.233))) * 43758.5453);
            }

            void main() {
                vec4 color = texture2D(inputImageTexture, textureCoordinate);
                float noise = rand(textureCoordinate) * intensity;
                gl_FragColor = vec4(color.rgb + vec3(noise), color.a);
            }
        """
    }

    private var intensityLocation: Int = 0
    private var intensity: Float = 0.5f

    override fun onInit() {
        super.onInit()
        intensityLocation = GLES20.glGetUniformLocation(program, "intensity")
    }

    override fun onInitialized() {
        super.onInitialized()
        setIntensity(intensity)
    }

    fun setIntensity(intensity: Float) {
        this.intensity = intensity
        setFloat(intensityLocation, intensity)
    }
}
