package br.com.candeias.treino.model

import java.net.URL

class Exercicio {

    var id: String = ""

    var nome: Long? = null

    var imagem: URL? = null

    var observacoes: String? = null

    override fun hashCode(): Int {
        return id.hashCode()
    }

    override fun equals(o: Any?): Boolean {
        var o = o ?: return false
        try {
            o = o as Exercicio
        } catch (e: ClassCastException) {
            e.printStackTrace()
        }
        if (javaClass != o.javaClass) {
            return false
        }
        return this.id.equals((o as Exercicio).id)
    }

}