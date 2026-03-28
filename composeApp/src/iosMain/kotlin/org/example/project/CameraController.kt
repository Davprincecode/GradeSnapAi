package org.example.project

import kotlinx.coroutines.suspendCoroutine
import platform.UIKit.*
import kotlin.coroutines.resume

actual class CameraController : NSObject(), UIImagePickerControllerDelegateProtocol, UINavigationControllerDelegateProtocol {

    private var completion: ((ByteArray?) -> Unit)? = null

    actual suspend fun captureImage(): ByteArray? = suspendCoroutine { cont ->
        completion = { imageData -> cont.resume(imageData) }

        val picker = UIImagePickerController()
        picker.sourceType = UIImagePickerControllerSourceType.Camera
        picker.delegate = this

        val rootController = UIApplication.sharedApplication.keyWindow?.rootViewController
        rootController?.presentViewController(picker, animated = true, completion = null)
    }

    @ObjCAction
    fun imagePickerController(
        picker: UIImagePickerController,
        didFinishPickingMediaWithInfo info: Map<Any?, *>
    ) {
        val image = info[UIImagePickerControllerOriginalImage] as? UIImage
        val data = image?.JPEGRepresentation(1.0)?.toByteArray()
        completion?.invoke(data)
        picker.dismissViewControllerAnimated(true, completion = null)
    }
}
