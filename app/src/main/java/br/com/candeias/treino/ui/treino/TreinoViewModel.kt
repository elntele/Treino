package br.com.candeias.treino.ui.treino

import androidx.lifecycle.ViewModel
import br.com.candeias.treino.model.Treino
import br.com.candeias.treino.repository.TreinoRepository

class TreinoViewModel : ViewModel() {


    fun getTreinos(): MutableList<Treino>? {
        var treino=  TreinoRepository?.getTreinoout()
        return treino
    }

    fun loadTreinosFromRemoteBank(){

        TreinoRepository?.getInstancesFromApiFireBase()
    }
}