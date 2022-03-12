package br.com.candeias.treino.model
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference


class Treino {
     var id = ""

     var nome: Long? = null

     var descricao: String? = null

     var data: Timestamp? = null

     var exercicios: ArrayList<Exercicio> = ArrayList()

     var strinExe: ArrayList<DocumentReference> = ArrayList()
}