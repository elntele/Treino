package br.com.candeias.treino.ui.treino

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.candeias.treino.R

class TreinoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.treino_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, TreinoFragment.newInstance())
                .commitNow()
        }
    }
}