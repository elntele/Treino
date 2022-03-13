package br.com.candeias.treino

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.test.core.app.ApplicationProvider
import br.com.candeias.treino.repository.TreinoRepository
import br.com.candeias.treino.ui.main.MainFragment
import br.com.candeias.treino.ui.treino.TreinoActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        // teste em treino repositori
        TreinoRepository.getInstancesFromApiFireBase()

        val intent = Intent(
            this,
            TreinoActivity::class.java
        )

        startActivity(intent)

        /*if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }*/
    }
}