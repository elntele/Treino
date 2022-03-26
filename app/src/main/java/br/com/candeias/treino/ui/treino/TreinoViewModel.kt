package br.com.candeias.treino.ui.treino

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.candeias.treino.model.Treino
import br.com.candeias.treino.repository.TreinoRepository


class TreinoViewModel(val treinoRepository: TreinoRepository) : ViewModel() {
    private val _onLiveData = MutableLiveData<List<Treino>>()
    val onLiveData = MutableLiveData<List<Treino>>()

    var listtreinos: MutableList<Treino> = ArrayList()

    fun getTreinos(): MutableList<Treino>? {
        var treino = TreinoRepository?.getTreinoout()
        return treino
    }

    fun updateTreinosFromBack (){

        onLiveData.value=TreinoRepository?.getTreinoout()

    }

    fun loadTreinosFromRemoteBank() {

        TreinoRepository?.getInstancesFromApiFireBase()
    }
}