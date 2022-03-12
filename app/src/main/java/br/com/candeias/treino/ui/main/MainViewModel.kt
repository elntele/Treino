package br.com.candeias.treino.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.candeias.treino.ui.treino.TreinoViewModel

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    val mViewModel = ViewModelProvider.NewInstanceFactory()
        .create(TreinoViewModel::class.java)
}