package com.rozi.bwamov.checkout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.rozi.bwamov.R
import com.rozi.bwamov.model.Checkout
import com.rozi.bwamov.utils.Preferences
import kotlinx.android.synthetic.main.activity_checkout.*
import java.util.ArrayList


class CheckoutActivity : AppCompatActivity() {

    private var dataList = ArrayList<Checkout>()
    private var total : Int = 0
    private lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)

        preferences = Preferences(this)
        dataList = intent.getSerializableExtra("data") as ArrayList<Checkout>

        for (a in dataList.indices){
            total += dataList[a].harga!!.toInt()
        }

        dataList.add(Checkout("Total harus dibayar", total.toString()))

        rv_checkoutt.layoutManager = LinearLayoutManager(this)
        rv_checkoutt.adapter = CheckoutAdapter(dataList){

        }

        btn_tiket.setOnClickListener {
            val intent = Intent(this, CheckoutSuccesActivity::class.java)
            startActivity(intent)
        }
    }

}