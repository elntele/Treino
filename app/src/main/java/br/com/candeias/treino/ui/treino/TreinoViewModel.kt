package br.com.candeias.treino.ui.treino

import androidx.lifecycle.ViewModel
import br.com.candeias.treino.model.Treino
import br.com.candeias.treino.repository.TreinoRepository

class TreinoViewModel (val treinoRepository: TreinoRepository): ViewModel() {


    fun getTreinos(): MutableList<Treino>? {
        var treino=  treinoRepository?.getTreinoout()
        return treino
    }

    fun loadTreinosFromRemoteBank(){

        treinoRepository?.getInstancesFromApiFireBase()
    }
}