package util.singleton

import com.google.firebase.storage.FirebaseStorage

class FireBaseStarangeApi {
    companion object {
        private var storage: FirebaseStorage?=null;

        //padrão sigleton
        fun getStorangeRefe(): FirebaseStorage? {
            if (storage == null) {
                storage = FirebaseStorage.getInstance();
            }
            return storage
        }
    }
}