package com.example.newproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.newproject.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {


    private lateinit var binding: ActivityLoginBinding
    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        databaseHelper = DatabaseHelper(this)

        binding.loginButton.setOnClickListener{
            val loginUsername = binding.loginUsername.text.toString()
            val loginPassword = binding.loginPassword.text.toString()
            loginDatabase(loginUsername,loginPassword)
        }
        binding.singupRedirect.setOnClickListener{
            val intent = Intent(this,SingupActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
    private fun loginDatabase(username: String, password: String){
        val  userExists = databaseHelper.readUser(username,password)
        if (userExists){
            Toast.makeText(this,"เข้าสู่ระบบสำเร็จ",Toast.LENGTH_SHORT).show()
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        } else{
            Toast.makeText(this,"การเข้าสู่ระบบล้มเหลว", Toast.LENGTH_SHORT).show()
        }
    }

}



