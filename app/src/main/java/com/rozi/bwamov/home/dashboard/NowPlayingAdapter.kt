package com.rozi.bwamov.home.dashboard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rozi.bwamov.R
import com.rozi.bwamov.model.Film

class NowPlayingAdapter(private var data: List<Film>,
                        private var listener:(Film)-> Unit)
    : RecyclerView.Adapter<NowPlayingAdapter.ViewHolder>() {

    lateinit var contextAdapter : Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NowPlayingAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        contextAdapter = parent.context
        val inflatedView = layoutInflater.inflate(R.layout.row_item_playing, parent, false)
        return ViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: NowPlayingAdapter.ViewHolder, position: Int) {
        holder.bindItem(data[position],listener, contextAdapter)
    }

    override fun getItemCount(): Int = data.size

    class ViewHolder(view:View) : RecyclerView.ViewHolder(view){
        private val tvTittle : TextView = view.findViewById(R.id.tv_kursi)
        private val tvGenrei : TextView = view.findViewById(R.id.tv_genrei)
        private val tvRating : TextView = view.findViewById(R.id.tv_rate)

        private val tvImage : ImageView = view.findViewById(R.id.iv_poster_image)

        fun bindItem(data:Film, listener: (Film) -> Unit, context: Context){
            tvTittle.setText(data.judul)
            tvGenrei.setText(data.genre)
            tvRating.setText(data.rating)

            Glide.with(context)
                .load(data.poster)
                .into(tvImage)

            itemView.setOnClickListener {
                listener(data)
            }
        }
    }

}
