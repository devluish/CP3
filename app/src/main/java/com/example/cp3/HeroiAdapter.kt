package com.example.cp3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class HeroiAdapter : RecyclerView.Adapter<HeroiAdapter.HeroiViewHolder>() {

    //Lista de herois que será exibida na RecycleView

    private var herois: List<Heroi> = emptyList()


    //Método chamado quando o ViewHolder precisa ser criado
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HeroiAdapter.HeroiViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_item_herois, parent, false)
        return HeroiViewHolder
    }

    //Método chamado para atualizar a visualização de um ViewHolder com dados especificos
    override fun onBindViewHolder(holder: HeroiAdapter.HeroiViewHolder, position: Int) {
        //Obter o Heroi na posição especifica da lista de Herois
        val heroi = herois[position]
        //Atualizar a visualização do ViewHolder com os dados do Heroi
        holder.bind(heroi)
    }

    //Método para obter número total de itens na lista

    override fun getItemCount(): Int {
        return herois.size
    }

    //Método para atualizar a lista de Herois e notificar a RecycleView
    fun setDada(data: List<Heroi>) {
        herois = data
        notifyDataSetChanged() //Notifica a RecycleView sobre as mudanças dos dados
    }

    inner class HeroiViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        //Referencia aos alementos de layout do item_herois.xml
        private val titleTextView: TextView = itemView.findViewById(R.id.heroTitleTextView)
        private val yearTextView: TextView = itemView.findViewById(R.id.heroYearTextView)

        //Método para vincular os dados do Heroi a visualização do ViewHolder
        fun bind(heroi: Heroi) {
            titleTextView.text = heroi.title
            yearTextView.text = heroi.releaseYear.toString() //Define o ano de lançamento do heroi no TextView

        }
    }

}

