package br.com.candeias.treino.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.candeias.treino.R
import br.com.candeias.treino.ui.treino.TreinoActivity

class MainActivity : AppCompatActivity() {
    private var savedInstanceState: Bundle? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            this.savedInstanceState = savedInstanceState
        }
        setContentView(R.layout.main_activity)
    }

    override fun onStart() {
        super.onStart()
        routing()
    }

    private fun routing() {
        val intent = Intent(
            this,
            TreinoActivity::class.java
        )
        startActivity(intent)
    }

}

