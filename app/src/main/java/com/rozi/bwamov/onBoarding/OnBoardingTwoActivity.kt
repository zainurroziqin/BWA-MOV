package com.rozi.bwamov.onBoarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rozi.bwamov.R
import kotlinx.android.synthetic.main.activity_on_boarding_two.*

class OnBoardingTwoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding_two)

        btn_home.setOnClickListener {
            var intent = Intent(this@OnBoardingTwoActivity, OnBoardingTreeActivity::class.java)
            startActivity(intent)
        }

    }
}