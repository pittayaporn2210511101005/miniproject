package com.example.newproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast

class order : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        // ดักจับการคลิกปุ่มกากบาท
        val goBackhome: ImageButton = findViewById(R.id.gohome)
        goBackhome.setOnClickListener {
            // ใช้ Intent เพื่อไปยัง MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // ปิดหน้า order
        }

        val radioGroup: RadioGroup = findViewById(R.id.radioGroup)
        val button: Button = findViewById(R.id.buttonConfirm)

        button.setOnClickListener {
            val selectedId = radioGroup.checkedRadioButtonId
            val radioButton: RadioButton = findViewById(selectedId)

            if (selectedId != -1) {
                // แสดงข้อความหรือดำเนินการตามตัวเลือก
                val selectedOption = radioButton.text.toString()
                Toast.makeText(this, "คุณเลือก: $selectedOption", Toast.LENGTH_SHORT).show()

                // รับข้อมูลจาก Intent (รายการอาหารและราคาทั้งหมด)
                val food1 = intent.getStringExtra("food1")
                val food2 = intent.getStringExtra("food2")
                val totalPrice = intent.getIntExtra("totalPrice", 0)

                // ส่งข้อมูลไปที่หน้าจอ confirm
                val confirmIntent = Intent(this, confirm::class.java)
                confirmIntent.putExtra("food1", food1)
                confirmIntent.putExtra("food2", food2)
                confirmIntent.putExtra("totalPrice", totalPrice)
                confirmIntent.putExtra("orderOption", selectedOption)  // ส่งตัวเลือกของการสั่งอาหาร
                startActivity(confirmIntent)
            } else {
                Toast.makeText(this, "กรุณาเลือกตัวเลือก", Toast.LENGTH_SHORT).show()
            }
        }

        // รับข้อมูลจาก Intent ที่มากับหน้า order
        val food1 = intent.getStringExtra("food1")
        val food2 = intent.getStringExtra("food2")
        val totalPrice = intent.getIntExtra("totalPrice", 0)

        // หาผลลัพธ์ที่จะนำไปแสดงในหน้าจอ
        val orderSummary: TextView = findViewById(R.id.orderSummary)
        orderSummary.text = "รายการอาหาร:\n$food1\n$food2\n\nรวม: $totalPrice บาท"
    }
}
