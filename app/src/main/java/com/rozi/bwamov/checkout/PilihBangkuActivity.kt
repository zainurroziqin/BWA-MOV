package com.rozi.bwamov.checkout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.rozi.bwamov.R
import com.rozi.bwamov.model.Checkout
import com.rozi.bwamov.model.Film
import kotlinx.android.synthetic.main.activity_pilih_bangku.*
import java.util.ArrayList

class PilihBangkuActivity : AppCompatActivity() {

    var statusA3 : Boolean = false
    var statusA4 : Boolean = false
    var total : Int = 0

    private var dataList = ArrayList<Checkout>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pilih_bangku)

        val data = intent.getParcelableExtra<Film>("data")
        tv_kursi.text = data!!.judul

        iv_a3.setOnClickListener {
            if (statusA3){
                iv_a3.setImageResource(R.drawable.ic_rectangle_empty)
                statusA3 = false
                total -= 1
                beliTiket(total)
            }else{
                iv_a3.setImageResource(R.drawable.ic_rectangle_selected)
                statusA3 = true
                total += 1
                beliTiket(total)
                val data = Checkout("A3", "70000")
                dataList.add(data)
            }
        }
        iv_a4.setOnClickListener {
            if (statusA4){
                iv_a4.setImageResource(R.drawable.ic_rectangle_empty)
                statusA4 = false
                total -= 1
                beliTiket(total)
            }else{
                iv_a4.setImageResource(R.drawable.ic_rectangle_selected)
                statusA4 = true
                total += 1
                beliTiket(total)
                val data = Checkout("a4", "70000")
                dataList.add(data)
            }
        }

        btn_home.setOnClickListener {
            var intent = Intent(this, CheckoutActivity::class.java).putExtra("data", dataList)
            startActivity(intent)
        }

    }

    private fun beliTiket(total: Int) {
        if (total ==0){
            btn_home.setText("Beli Tiket")
            btn_home.visibility = View.INVISIBLE
        }else{
            btn_home.setText("Beli Tiket("+total+")")
            btn_home.visibility = View.VISIBLE
        }
    }
}