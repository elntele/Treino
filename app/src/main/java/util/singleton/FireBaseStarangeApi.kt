package util.singleton

import com.google.firebase.storage.FirebaseStorage

object FireBaseStarangeApi {
    val storage = FirebaseStorage.getInstance();
}