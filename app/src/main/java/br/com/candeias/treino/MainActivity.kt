package br.com.candeias.treino

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.candeias.treino.repository.TreinoRepository
import br.com.candeias.treino.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        TreinoRepository.getInstancesFromApiFireBase()
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}