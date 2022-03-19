package br.com.candeias.treino.ui.wait

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import br.com.candeias.treino.R
import java.util.*


class WaitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wait)
        this.supportActionBar!!.hide()
        Handler().postDelayed({
            finish()
            //getActivity()?.getFragmentManager()?.popBackStack();
        }, 3000)
    }

}