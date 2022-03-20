package br.com.candeias.treino.di

import br.com.candeias.treino.ui.treino.TreinoViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { TreinoViewModel() }
}

