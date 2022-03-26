package br.com.candeias.treino.ui.treino


import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.candeias.treino.R
import br.com.candeias.treino.model.Treino
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.treino_card_view.view.*


class TreinoAdapter(
    val treinoViewModel: TreinoViewModel,
    treinoFragment: TreinoFragment, val context: Activity?
) :
    RecyclerView.Adapter<TreinoAdapter.TreinoAdapterViewHolder>() {
    private lateinit var treinos: MutableList<Treino>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TreinoAdapterViewHolder {
       treinos= treinoViewModel.getTreinos()!!

        val ItemLista: View = LayoutInflater.from(parent.getContext()).inflate(
            R.layout.treino_card_view, parent, false
        )
        return TreinoAdapterViewHolder(ItemLista)
    }

    override fun onBindViewHolder(holder: TreinoAdapterViewHolder, position: Int) {

        val mess: String? = context?.getString(R.string.continuarExerc)
        holder.title.setText(mess)
        holder.title.setText(treinos[position].descricao.toString())
        // isso tem que ir para a classe de api
        // isso tem que ir para a classe de api
       /* val storage = getStorangeRefe()
        val storageRef = storage!!.reference
        val folder = storageRef.child(treinos[position].id + "/")
        val file = folder.child(treinos[position].exercicios[1].id + ".png")*/

        try {
            Picasso.get().load(treinos[position].exercicios[1].imagem.toString())
                .placeholder(R.drawable.icone).error(R.drawable.icone).into(holder.image)
        } catch (e: NullPointerException) {
            e.printStackTrace()
        }

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
          val title: TextView = itemView.card_title
          val image: ImageView= itemView.card_image
          val text : TextView = itemView.card_text

    }

}