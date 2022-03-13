package br.com.candeias.treino.ui.treino

import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.treino_card_view.view.*

class TreinoAdapter(
    val treinoViewModel: TreinoViewModel,
    treinoFragment: TreinoFragment
) :
    RecyclerView.Adapter<TreinoAdapter.TreinoAdapterViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TreinoAdapterViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: TreinoAdapterViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        var size=0
        if (treinoViewModel.getTreinos()?.size!=null){
            size = treinoViewModel.getTreinos()?.size!!
        }
        return size
    }

    class TreinoAdapterViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        private  val title: TextView = itemView.card_title
        private  val image: ImageView= itemView.card_image
        private  val text : TextView = itemView.card_text

    }

}