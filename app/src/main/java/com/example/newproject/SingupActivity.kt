package com.example.newproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.newproject.databinding.ActivityLoginBinding
import com.example.newproject.databinding.ActivitySingupBinding

class SingupActivity : AppCompatActivity() {


    private lateinit var binding: ActivitySingupBinding
    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySingupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        databaseHelper = DatabaseHelper(this)

        binding.singupButton.setOnClickListener{
            val singupUsername = binding.singupUsername.text.toString()
            val singupPassword = binding.singupPassword.text.toString()
            singupDatabase(singupUsername,singupPassword)
        }

        binding.loginRedirect.setOnClickListener{
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }


    private fun singupDatabase(username: String, password: String){
        val insertedRowId = databaseHelper.insertUser(username, password)
        if (insertedRowId != -1L){
            Toast.makeText(this,"สมัครสำเร็จ",Toast.LENGTH_LONG).show()
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
            finish()
        } else{
            Toast.makeText(this,"ไม่สมัครสำเร็จ" , Toast.LENGTH_LONG).show()
        }
    }

}