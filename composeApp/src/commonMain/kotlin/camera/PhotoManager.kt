package camera

class PhotoManager(
    private val controller: CameraController
) {

    private val photos = mutableListOf<String>()

    suspend fun snap() {
        val path = controller.capturePhoto()
        photos.add(path)
    }

    fun allPhotos(): List<String> = photos
}