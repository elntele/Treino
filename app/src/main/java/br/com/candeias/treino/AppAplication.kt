package br.com.candeias.treino

import android.app.Application
import br.com.candeias.treino.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.fragment.koin.fragmentFactory
import org.koin.core.context.startKoin

class AppAplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@AppAplication)
            fragmentFactory()
            modules(viewModelModule)

        }
    }
}