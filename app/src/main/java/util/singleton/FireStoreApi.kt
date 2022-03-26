package util.singleton

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

object FireStoreApi {
    val firebaseFirestore = Firebase.firestore
}