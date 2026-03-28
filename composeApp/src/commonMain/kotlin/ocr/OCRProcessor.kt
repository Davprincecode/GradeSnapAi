package ocr

interface OCRProcessor {
    suspend fun recognizeText(imagePath: String): String
}