package br.com.candeias.treino.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.candeias.treino.R
import br.com.candeias.treino.repository.TreinoRepository
import br.com.candeias.treino.ui.treino.TreinoActivity
import br.com.candeias.treino.ui.treino.TreinoViewModel
import br.com.candeias.treino.ui.wait.WaitActivity
import org.koin.android.viewmodel.compat.ViewModelCompat
import org.koin.android.viewmodel.dsl.viewModel

class MainActivity : AppCompatActivity() {
    private  var savedInstanceState: Bundle?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            this.savedInstanceState=savedInstanceState
        }
        setContentView(R.layout.main_activity)
        // teste em treino repositori
        TreinoRepository.getInstancesFromApiFireBase()


    }

    override fun onStart() {
        super.onStart()
        routing()
    }

    private fun routing(){
        var size= TreinoRepository.getTreinoout().size
        if (size==0){
            val intent1 = Intent(
                this,
                WaitActivity::class.java
            )
            startActivity(intent1)

            }else{
                val intent = Intent(
                    this,
                    TreinoActivity::class.java
                )
                startActivity(intent)
            }

        }




}