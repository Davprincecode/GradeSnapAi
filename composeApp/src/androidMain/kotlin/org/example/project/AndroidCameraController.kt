package org.example.project

import android.content.Context
import androidx.camera.core.*
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import camera.CameraController
import kotlinx.coroutines.suspendCancellableCoroutine
import java.io.File
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

class AndroidCameraController (
    private val context: Context,
    private val lifecycleOwner: LifecycleOwner
) : CameraController {

    private var imageCapture: ImageCapture? = null
    private var previewView: PreviewView? = null

    fun bindPreview(view: PreviewView) {
        previewView = view
    }

    override fun startCamera() {

        val providerFuture =
            ProcessCameraProvider.getInstance(context)

        providerFuture.addListener({

            val cameraProvider = providerFuture.get()

            val preview = Preview.Builder().build()

            previewView?.let {
                preview.setSurfaceProvider(it.surfaceProvider)
            }

            imageCapture = ImageCapture.Builder().build()

            cameraProvider.unbindAll()

            cameraProvider.bindToLifecycle(
                lifecycleOwner,
                CameraSelector.DEFAULT_BACK_CAMERA,
                preview,
                imageCapture
            )

        }, ContextCompat.getMainExecutor(context))
    }

    override fun stopCamera() {
        imageCapture = null
    }

    override suspend fun capturePhoto(): String =
        suspendCancellableCoroutine { cont ->

            val file = File(
                context.cacheDir,
                "IMG_${System.currentTimeMillis()}.jpg"
            )

            val options =
                ImageCapture.OutputFileOptions.Builder(file).build()

            imageCapture?.takePicture(
                options,
                ContextCompat.getMainExecutor(context),
                object : ImageCapture.OnImageSavedCallback {

                    override fun onImageSaved(
                        output: ImageCapture.OutputFileResults
                    ) {
                        cont.resume(file.absolutePath)
                    }

                    override fun onError(exception: ImageCaptureException) {
                        cont.resumeWithException(exception)
                    }
                }
            )
        }
}
