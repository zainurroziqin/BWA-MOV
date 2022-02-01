package com.rozi.bwamov.onBoarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rozi.bwamov.R
import com.rozi.bwamov.sign.signIn.SignInActivity
import kotlinx.android.synthetic.main.activity_on_boarding_tree.*

class OnBoardingTreeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding_tree)

        btn_home.setOnClickListener {
            finishAffinity()
            var intent = Intent(this@OnBoardingTreeActivity, SignInActivity::class.java)
            startActivity(intent)
        }
    }
}