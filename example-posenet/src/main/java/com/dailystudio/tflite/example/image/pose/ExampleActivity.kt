package com.dailystudio.tflite.example.image.pose

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.dailystudio.devbricksx.development.Logger
import com.dailystudio.tflite.example.common.AbsExampleActivity
import com.dailystudio.tflite.example.common.image.ImageInferenceInfo
import com.dailystudio.tflite.example.image.pose.fragment.PoseCameraFragment
import com.dailystudio.tflite.example.image.pose.ui.PoseOverlayView
import org.tensorflow.lite.examples.posenet.lib.Person

class ExampleActivity : AbsExampleActivity<ImageInferenceInfo, Person>() {

    private var poseOverlay: PoseOverlayView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        poseOverlay =
            findViewById(R.id.overlay)
    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_example_pose
    }

    override fun createBaseFragment(): Fragment {
        return PoseCameraFragment()
    }

    override fun createSettingsView(): View? {
        return null
    }

    override fun createResultsView(): View? {
        return null
    }

    override fun onResultsUpdated(results: Person) {
        Logger.debug("detected pose: $results")
        poseOverlay?.setPersonPose(results)
    }

    override fun onInferenceInfoUpdated(info: ImageInferenceInfo) {
        super.onInferenceInfoUpdated(info)

        poseOverlay?.setFrameConfiguration(
            info.imageSize.width, info.imageSize.height,
            info.imageRotation)
    }

}