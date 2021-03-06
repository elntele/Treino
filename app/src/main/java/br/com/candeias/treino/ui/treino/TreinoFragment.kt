package br.com.candeias.treino.ui.treino

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.candeias.treino.R
import kotlinx.android.synthetic.main.treino_fragment.*


class TreinoFragment : Fragment() {

    companion object {
        fun newInstance() = TreinoFragment()
    }

    private lateinit var reciclerTreino: RecyclerView
    private lateinit var viewModel: TreinoViewModel

    private lateinit var treinoAdapter: TreinoAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        var view:View =inflater.inflate(R.layout.treino_fragment, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        reciclerTreino =  recycler_treino
        viewModel = ViewModelProvider(this).get(TreinoViewModel::class.java)
        treinoAdapter = TreinoAdapter(viewModel, this,  activity)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(activity)
        reciclerTreino.setLayoutManager(layoutManager)
        reciclerTreino.setAdapter(treinoAdapter)

    }

}