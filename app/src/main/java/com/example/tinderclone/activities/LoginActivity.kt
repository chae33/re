package com.example.tinderclone.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.tinderclone.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_signup.*

class LoginActivity : AppCompatActivity() {

    private var firebaseAuth = FirebaseAuth.getInstance()
    private var firebaseAuthListener = FirebaseAuth.AuthStateListener{
        val user = firebaseAuth.currentUser
        if(user != null){
            startActivity(TinderActivity.newIntent(this))
            finish()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    override fun onStart() {
        super.onStart()
        firebaseAuth.addAuthStateListener(firebaseAuthListener)
    }

    override fun onStop() {
        super.onStop()
        firebaseAuth.addAuthStateListener (firebaseAuthListener)
    }

    fun onLogin(v: View){
        if(!emailET.text.toString().isNullOrEmpty() && !password_ET.text.toString().isNullOrEmpty()){
            firebaseAuth.signInWithEmailAndPassword(emailET.text.toString(), password_ET.text.toString())
                .addOnCompleteListener{task ->
                    if(!task.isSuccessful){
                        Toast.makeText(this,"Login error ${task.exception?.localizedMessage}",Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }

    companion object{
        fun newIntent(context: Context?)= Intent(context,LoginActivity::class.java)
    }
}