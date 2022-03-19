package br.com.candeias.treino.model
import com.google.firebase.Timestamp
import com.google.firebase.firestore.DocumentReference


class Treino {
     var id = ""

     var nome: Long? = null

     var descricao: String? = null

     var data: Timestamp? = null

     var exercicios: ArrayList<Exercicio> = ArrayList()

     var strinExe: ArrayList<DocumentReference> = ArrayList()

     override fun hashCode(): Int {
          return id.hashCode()
     }

     override fun equals(o: Any?): Boolean {
          var o = o ?: return false
          try {
               o = o as Treino
          } catch (e: ClassCastException) {
               e.printStackTrace()
          }
          if (javaClass != o.javaClass) {
               return false
          }
          return this.id.equals((o as Treino).id)
     }



}