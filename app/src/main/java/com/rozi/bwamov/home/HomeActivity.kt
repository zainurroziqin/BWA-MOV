package com.rozi.bwamov.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.rozi.bwamov.R
import com.rozi.bwamov.home.dashboard.DashboardFragment
import com.rozi.bwamov.home.setting.SettingFragment
import com.rozi.bwamov.home.tiket.TiketFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val fragmentHome = DashboardFragment()
        val fragmentTiket = TiketFragment()
        val fragmentProfile = SettingFragment()

        setFragment(fragmentHome)

        menu1.setOnClickListener {
            setFragment(fragmentHome)
            changeIcon(menu1, R.drawable.ic_home_active)
            changeIcon(menu2, R.drawable.ic_tiket)
            changeIcon(menu3, R.drawable.ic_profile)
        }
        menu2.setOnClickListener {
            setFragment(fragmentTiket)
            changeIcon(menu1, R.drawable.ic_home)
            changeIcon(menu2, R.drawable.ic_tiket_active)
            changeIcon(menu3, R.drawable.ic_profile)
        }
        menu3.setOnClickListener {
            setFragment(fragmentProfile)
            changeIcon(menu1, R.drawable.ic_home)
            changeIcon(menu2, R.drawable.ic_tiket)
            changeIcon(menu3, R.drawable.ic_profile_active)
        }
    }

    private fun setFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTrascation = fragmentManager.beginTransaction()
        fragmentTrascation.replace(R.id.layout_frame, fragment)
        fragmentTrascation.commit()
    }

    private fun changeIcon(imageView: ImageView, int : Int){
        imageView.setImageResource(int)
    }
}