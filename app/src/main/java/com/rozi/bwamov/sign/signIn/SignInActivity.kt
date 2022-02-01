package com.rozi.bwamov.sign.signIn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.*
import com.rozi.bwamov.R
import kotlinx.android.synthetic.main.activity_sign_in.*
import com.rozi.bwamov.home.HomeActivity
import com.rozi.bwamov.sign.signUp.SignUpActivity
import com.rozi.bwamov.utils.Preferences


class SignInActivity : AppCompatActivity() {

    lateinit var  iUsername:String
    lateinit var  iPassword:String

    lateinit var  mDatabase : DatabaseReference
    lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        mDatabase = FirebaseDatabase.getInstance().getReference("User")
        preferences = Preferences(this)

        preferences.setValues("onBoarding", "1")
        if (preferences.getValues("status").equals("1")){
            finishAffinity()
            var goHome = Intent(this@SignInActivity, HomeActivity::class.java)
            startActivity(goHome)
        }
        btn_signIn.setOnClickListener {
            iUsername = et_username.text.toString()
            iPassword = et_password.text.toString()

            if (iUsername.equals("")){
                et_username.error = "Silahkan tulis username terlebih dahulu"
                et_username.requestFocus()
            }else if (iPassword.equals("")){
                et_password.error = "Silahkan tulis password terlebih dahulu"
                et_password.requestFocus()
            }else{
                pushLogin(iUsername, iPassword)
            }
        }

        btn_daftar.setOnClickListener {
            var intent = Intent(this@SignInActivity, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

    private fun pushLogin(iUsername: String, iPassword: String) {
        mDatabase.child(iUsername).addValueEventListener(object : ValueEventListener{
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                var user = dataSnapshot.getValue(User::class.java)
                if (user == null){
                    Toast.makeText(this@SignInActivity, "User tidak terdaftar", Toast.LENGTH_LONG).show()
                }else{
                    if (user.password.equals(iPassword)){
                        preferences.setValues("nama", user.nama.toString())
                        preferences.setValues("user", user.username.toString())
                        preferences.setValues("url", user.url.toString())
                        preferences.setValues("saldo", user.saldo.toString())
                        preferences.setValues("email", user.email.toString())
                        preferences.setValues("status", "1")

                        var intent = Intent(this@SignInActivity, HomeActivity::class.java)
                        startActivity(intent)
                    }else{
                        Toast.makeText(this@SignInActivity, "Password anda salah", Toast.LENGTH_LONG).show()
                    }

                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Toast.makeText(this@SignInActivity, databaseError.message, Toast.LENGTH_LONG).show()
            }
        })
    }
}