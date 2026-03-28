package camera

interface CameraController {

    fun startCamera()

    fun stopCamera()

    suspend fun capturePhoto(): String
}