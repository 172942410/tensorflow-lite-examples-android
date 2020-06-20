package com.dailystudio.tflite.example.common

import android.content.Context
import android.util.Size
import com.dailystudio.tflite.example.common.ui.InferenceInfoItem

open class InferenceInfo(var analysisTime: Long = 0,
                         var inferenceTime: Long = 0) {

    open fun toInfoItems(context: Context): MutableList<InferenceInfoItem> {
        val items = mutableListOf<InferenceInfoItem>()

        val resources = context.resources

        val itemAnalysisTime = InferenceInfoItem(5, R.drawable.ic_info_analysis_time,
            resources.getString(R.string.label_info_analysis_time),
            "%d ms".format(analysisTime))
        items.add(itemAnalysisTime)

        val itemInferenceTime = InferenceInfoItem(6, R.drawable.ic_info_inference_time,
            resources.getString(R.string.label_info_inference_time),
            "%d ms".format(inferenceTime))
        items.add(itemInferenceTime)

        return items
    }

    override fun toString(): String {
        return buildString {
            append("analysis time: $analysisTime,")
            append("inference time: $inferenceTime")
        }
    }

}

open class ImageInferenceInfo(var imageSize: Size = Size(0, 0),
                              var imageRotation: Int = 0,
                              var screenRotation: Int = 0,
                              var inferenceImageSize: Size = Size(0, 0),
                              analysisTime: Long = 0,
                              inferenceTime: Long = 0): InferenceInfo(analysisTime, inferenceTime) {

    override fun toInfoItems(context: Context): MutableList<InferenceInfoItem> {
        val items = super.toInfoItems(context)

        val resources = context.resources

        val itemImageSize = InferenceInfoItem(1, R.drawable.ic_info_image_size,
            resources.getString(R.string.label_info_image_size), imageSize.toString())
        items.add(itemImageSize)

        val itemImageRotation = InferenceInfoItem(2, R.drawable.ic_info_image_rotation,
            resources.getString(R.string.label_info_image_rotation), imageRotation.toString())
        items.add(itemImageRotation)

        val itemScreenRotation = InferenceInfoItem(3, R.drawable.ic_info_screen_rotation,
            resources.getString(R.string.label_info_screen_rotation), screenRotation.toString())
        items.add(itemScreenRotation)

        val itemInferenceImageSize = InferenceInfoItem(4, R.drawable.ic_info_inference_image_size,
            resources.getString(R.string.label_info_inference_image_size), inferenceImageSize.toString())
        items.add(itemInferenceImageSize)

        return items
    }

    override fun toString(): String {
        return buildString {
            append("image size: $imageSize,")
            append("image rotation: $imageRotation,")
            append("screen rotation: $screenRotation,")
            append("inference size: $inferenceImageSize,")
            append(super.toString())
        }
    }

}
