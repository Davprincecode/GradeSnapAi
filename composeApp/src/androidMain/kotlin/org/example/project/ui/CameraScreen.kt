package org.example.project.ui


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.LocalLifecycleOwner
import camera.PhotoManager
import kotlinx.coroutines.launch
import org.example.project.AndroidCameraController
import org.example.project.AndroidOCRProcessor

@Composable
fun CameraScreen() {

    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    val controller = remember {
        AndroidCameraController(context, lifecycleOwner)
    }

    val manager = remember {
        PhotoManager(controller)
    }

    val ocr = remember { AndroidOCRProcessor() }

    val scope = rememberCoroutineScope()

    var ocrResult by remember { mutableStateOf("") }

    Column(Modifier.fillMaxSize()) {

        CameraPreview(controller)

        Row {

            Button(
                onClick = {
                    scope.launch {
                        manager.snap()
                    }
                }
            ) {
                Text("Snap")
            }

            Button(
                onClick = {
                    scope.launch {

                        val texts = manager.allPhotos().map {
                            ocr.recognizeText(it)
                        }

                        ocrResult = texts.joinToString("\n\n")
                    }
                }
            ) {
                Text("Done + OCR")
            }
        }

        Text(ocrResult)
    }
}