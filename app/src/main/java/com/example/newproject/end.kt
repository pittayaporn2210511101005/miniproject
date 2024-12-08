package com.example.newproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class end : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end)


        // หา ImageButton ที่มี id "gologin"
        val goLoginButton: ImageButton = findViewById(R.id.gologin)
        goLoginButton.setOnClickListener {
            // สั่งให้เปิดหน้า LoginActivity
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish() // ปิดหน้า EndActivity
        }
    }
}
