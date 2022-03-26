package br.com.candeias.treino.ui.treino

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.candeias.treino.model.Treino
import br.com.candeias.treino.repository.TreinoRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class TreinoViewModel(val treinoRepository: TreinoRepository) : ViewModel() {
    private val _onLiveData = MutableLiveData<List<Treino>>()
    val onLiveData = _onLiveData


    var listtreinos: MutableList<Treino> = ArrayList()

   /* fun getTreinos() {
        var treino = TreinoRepository?.getTreinoout()

    }*/



    fun requestDataDownloadFromBack (){
        GlobalScope.launch {
            _onLiveData.postValue(TreinoRepository.getdata())
        }

    }

    /*fun loadTreinosFromRemoteBank() {

        TreinoRepository?.getInstancesFromApiFireBase()
    }*/
}