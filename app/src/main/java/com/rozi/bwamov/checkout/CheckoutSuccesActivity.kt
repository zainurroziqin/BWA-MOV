package com.rozi.bwamov.checkout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rozi.bwamov.R
import com.rozi.bwamov.home.HomeActivity
import kotlinx.android.synthetic.main.activity_checkout_succes.*

class CheckoutSuccesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout_succes)

        btn_home.setOnClickListener {
            finishAffinity()
            var intent = Intent(this,HomeActivity::class.java)
            startActivity(intent)
        }
    }
}