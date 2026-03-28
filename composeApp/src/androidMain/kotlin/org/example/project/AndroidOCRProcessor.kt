package org.example.project


import android.graphics.BitmapFactory
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.latin.TextRecognizerOptions
import kotlinx.coroutines.tasks.await
import ocr.OCRProcessor

class AndroidOCRProcessor : OCRProcessor {

    private val recognizer =
        TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS)

    override suspend fun recognizeText(imagePath: String): String {

        val bitmap = BitmapFactory.decodeFile(imagePath)

        val image = InputImage.fromBitmap(bitmap, 0)

        val result = recognizer.process(image).await()

        return result.text
    }
}