package com.example.newproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class confirm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm)
        // หา Button "สั่งอาหารต่อ"
        val comebackButton: Button = findViewById(R.id.comeback)
        comebackButton.setOnClickListener {
            // สั่งให้เปิดหน้า MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // ปิดหน้าปัจจุบัน
        }

        // หา Button "พอแค่นี้" (หากต้องการไปหน้า EndActivity)
        val endButton: Button = findViewById(R.id.end)
        endButton.setOnClickListener {
            // เปิดหน้า EndActivity เมื่อกด "พอแค่นี้"
            val intent = Intent(this, end::class.java)
            startActivity(intent)
            finish() // ปิดหน้า ConfirmActivity นี้
        }
    }
}