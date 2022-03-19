package br.com.candeias.treino.repository


import android.content.ContentValues.TAG
import android.util.Log
import br.com.candeias.treino.model.Exercicio
import br.com.candeias.treino.model.Treino
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.Timestamp
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.QueryDocumentSnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import util.singleton.FireBaseStarangeApi
import java.net.MalformedURLException
import java.net.URL


object TreinoRepository {

    private val exercicios: MutableList<Exercicio> = ArrayList()
    private val treinos = mutableListOf<Treino>()
    private val treinoout: MutableList<Treino> = ArrayList()
    private val treino = "TREINO"
    private val exercicio = "EXERCICIO"
    private val idMap: HashMap<String, String> = HashMap()


    private var f: TreinoRepository? = null

    private fun TreinoRepository() {
    }

   /* @Synchronized
    fun getIntance(): TreinoRepository? {
        if (f == null) {
            f = this
        }
        return f
    }*/


    fun getInstancesFromApiFireBase() {
        //val fireStoredb: FirebaseFirestore? = FireStoreApi.firebaseFirestore
        val fireStoredb = Firebase.firestore
        fireStoredb?.collection(exercicio)
            ?.get()?.addOnSuccessListener { result ->
                val exeList: MutableList<Exercicio> = ArrayList()
                for (document in result) {
                    val e: Exercicio = fillExercicioInstance(document)
                    exeList.add(e)
                    if (!exercicios.contains(e)) {
                        exercicios.add(e)
                    }
                    getIsntancesOfTreinoFronApiFireBase(e)
                }
            }
            ?.addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents.", exception)
            }

    }

    private fun getIsntancesOfTreinoFronApiFireBase(exec: Exercicio) {
        //val fireStoredb: FirebaseFirestore? = FireStoreApi.firebaseFirestore
        val fireStoredb = Firebase.firestore
        val d: DocumentReference? = fireStoredb?.document(exercicio + "/" + exec.id)
        d?.let { fireStoredb?.collection(treino)?.whereArrayContains("exercicios", it) }
            ?.get()?.addOnSuccessListener { result ->
                for (document in result) {
                    val t = fillTreinoInstance(document)
                    if (!treinoout.contains(t)) {
                        treinoout.add(t)
                    }
                    getUrlImages(t.id, exec)
                }
            }
            ?.addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents.", exception)
            }
    }


    private fun fillExercicioInstance(d: QueryDocumentSnapshot): Exercicio {
        val e = Exercicio()
        e.id = d.getId()
        e.nome = d.getLong("nome")
        e.observacoes = d.get("observacoes").toString()
        return e
    }

    private fun fillTreinoInstance(d: QueryDocumentSnapshot): Treino {
        val t = Treino()
        t.id = d.getId()
        t.nome = d.getLong("nome")
        t.data = d.get("data") as Timestamp
        t.descricao = d.get("descricao").toString()
        t.nome = d.get("nome") as Long
        t.strinExe = d.get("exercicios") as ArrayList<DocumentReference>

        return t
    }


    fun getTreinoout(): MutableList<Treino> {
        val localList: MutableList<Treino> = ArrayList()
        val r: MutableList<Treino> = ArrayList()
        localList.addAll(treinoout)
        val set = HashSet<Treino>()
        set.addAll(treinoout)
        r.addAll(set.toMutableList())

        for (t in r) {
            for (e in exercicios) {
                for (d in t.strinExe) {
                    val ls: String = d.getPath()
                    val l = ls.split("/").toTypedArray()
                    val idDtr = l[1]
                    if (e.id.equals(idDtr)) {
                        if (!t?.exercicios.contains(e)) {
                            t.exercicios.add(e)
                        }
                    }
                }
            }
        }
        return r
    }


    private fun getUrlImages(idTreino: String, e: Exercicio) {
        val storage: FirebaseStorage? = FireBaseStarangeApi.Companion.getStorangeRefe()
        val storageRef: StorageReference = storage!!.getReference()
        val folder: StorageReference = storageRef.child("$idTreino/")
        val file: StorageReference = folder.child(e.id.toString().toString() + ".png")
        file.getDownloadUrl().addOnSuccessListener(OnSuccessListener<Any> { uri ->
            try {
                val url = URL(uri.toString())
                e.imagem = url
            } catch (malformedURLException: MalformedURLException) {
                malformedURLException.printStackTrace()
            }
        }).addOnFailureListener(OnFailureListener { exception ->
            Log.d(
                "Falha",
                "in method getUrlImages $exception"
            )
        })
    }


   /* fun putTreino(t: Treino, key: String) {
        val fireStoredb: FirebaseFirestore? = FireStoreApi.Companion.getFirebaseFirestore()
        // Create a new user with a first and last name
        val treino: MutableMap<String, Any> = HashMap()
        treino["nome"] = t.nome!!
        treino["descricao"] = t.descricao!!
        treino["data"] = t.data!!
        val l: MutableList<String> = ArrayList()
        for (e in t.exercicios) {
            l.add(this.treino + "/" + e.id)
        }
        treino["exercicios"] = l
        fireStoredb?.collection(this.treino)?
            .add(treino)
            .addOnSuccessListener(OnSuccessListener<Any> { documentReference ->
                Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference)
                idMap[key] = documentReference.getId().toString()
                return@OnSuccessListener
            })
            .addOnFailureListener(OnFailureListener { e ->
                Log.w(TAG, "Error adding document", e)
                return@OnFailureListener
            })
    }

    fun putTreinputTreinoCompleto(t: Treino?) {
        val fireStoredb: FirebaseFirestore = FireStoreApi.Companion.getFirebaseFirestore()
        fireStoredb.collection(treino)
            .add(t)
            .addOnSuccessListener(OnSuccessListener<Any> { documentReference ->
                Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId())
                return@OnSuccessListener
            })
            .addOnFailureListener(OnFailureListener { e ->
                Log.w(TAG, "Error adding document", e)
                return@OnFailureListener
            })
    }

    fun updateTreino(id: String) {
        val fireStoredb: FirebaseFirestore = FireStoreApi.Companion.getFirebaseFirestore()
        // Create a new user with a first and last name
        val treino: MutableMap<String, Any> = HashMap()
        val l: MutableList<String> = ArrayList()
        l.add(exercicio + "/" + id)
        *//*    l.add(this.treino + "/" + "teste");
        l.add(this.treino + "/" + "teste");
        l.add(this.treino + "/" + "teste");*//*treino["exercicios"] = l
        fireStoredb.collection(this.treino).document("OvQMQiHyfAiYS71RAIBM")
            .set(treino, SetOptions.merge())
    }

    fun putExercicio(e: Exercicio) {
        val fireStoredb: FirebaseFirestore = FireStoreApi.Companion.getFirebaseFirestore()
        // Create a new user with a first and last name
        val exercicio: MutableMap<String, Any> = HashMap()
        exercicio["nome"] = e.getNome()
        exercicio["observacoes"] = e.getObservacoes()
        exercicio["imagem"] = e.getImagem()
        fireStoredb.collection(this.exercicio)
            .add(exercicio)
            .addOnSuccessListener(OnSuccessListener<Any> { documentReference ->
                Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId())
                return@OnSuccessListener
            })
            .addOnFailureListener(OnFailureListener { e ->
                Log.w(TAG, "Error adding document", e)
                return@OnFailureListener
            })
    }*/


}