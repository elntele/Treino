package br.com.candeias.treino.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.candeias.treino.repository.TreinoRepository
import br.com.candeias.treino.ui.treino.TreinoViewModel

@Suppress("UNCHECKED_CAST")
class TreinoViewModelFactory(val treinoRepository:TreinoRepository):ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        return TreinoViewModel(treinoRepository) as T
    }
}