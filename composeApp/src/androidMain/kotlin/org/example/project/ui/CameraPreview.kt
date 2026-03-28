package org.example.project.ui


import androidx.camera.view.PreviewView
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import org.example.project.AndroidCameraController

@Composable
fun CameraPreview(controller: AndroidCameraController) {

    AndroidView(
        factory = { context ->
            PreviewView(context).also {
                controller.bindPreview(it)
                controller.startCamera()
            }
        }
    )
}