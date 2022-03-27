package br.com.candeias.treino.ui.treino

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.candeias.treino.R
import org.koin.androidx.fragment.android.replace
import org.koin.androidx.fragment.android.setupKoinFragmentFactory

class TreinoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.treino_activity)
        setupKoinFragmentFactory()
        supportActionBar?.hide()
        supportFragmentManager.beginTransaction()
            .replace<TreinoFragment>(R.id.container, args=savedInstanceState)
            .commit()


        /*if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, TreinoFragment.newInstance())
                .commitNow()
        }*/
    }
}