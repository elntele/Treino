package br.com.candeias.treino.di

import br.com.candeias.treino.repository.TreinoRepository
import br.com.candeias.treino.ui.treino.TreinoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    //viewModel { (treinoRepository :TreinoRepository)->TreinoViewModel(treinoRepository) }
    single<TreinoRepository> { TreinoRepository }
    viewModel { TreinoViewModel(get()) }
}

