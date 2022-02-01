package com.rozi.bwamov.home.tiket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.rozi.bwamov.R
import com.rozi.bwamov.model.Checkout
import com.rozi.bwamov.model.Film
import kotlinx.android.synthetic.main.activity_tiket.*
import java.util.ArrayList

class TiketActivity : AppCompatActivity() {
    private var dataList = ArrayList<Checkout>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tiket)

        var data = intent.getParcelableExtra<Film>("data")
        tv_tittle.text = data!!.judul
        tv_genre.text = data.genre
        tv_rate.text = data.rating

        Glide.with(this)
            .load(data.poster)
            .into(iv_poster)

        rv_checkout.layoutManager = LinearLayoutManager(this)
        dataList.add(Checkout("C1", ""))
        dataList.add(Checkout("C2", ""))
        rv_checkout.adapter = TikettAdapter(dataList){

        }
    }
}