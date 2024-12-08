package com.example.newproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ดักจับการคลิกปุ่มกากบาท
        val goBackButton: ImageButton = findViewById(R.id.goback)
        goBackButton.setOnClickListener {
            // ใช้ Intent เพื่อไปยัง LoginActivity
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish() // ปิด MainActivity
        }

        // หาปุ่ม + และ - ของเมนูหมู
        val decrementButton: Button = findViewById(R.id.decrementButton)
        val incrementButton: Button = findViewById(R.id.incrementButton)
        val itemCount: TextView = findViewById(R.id.itemCount)

        // หาปุ่ม + และ - ของเมนูไก่
        val decrementButton1: Button = findViewById(R.id.decrementButton1)
        val incrementButton1: Button = findViewById(R.id.incrementButtonck)
        val itemCount1: TextView = findViewById(R.id.itemCountck)

        // ตั้งค่าเริ่มต้น
        var count = 0
        var count1 = 0
        val pricePork = 20  // ราคาอาหารหมู
        val priceChicken = 50  // ราคาอาหารไก่

        // ตั้งค่า Listener สำหรับปุ่ม - ของเมนูหมู
        decrementButton.setOnClickListener {
            if (count > 0) {
                count-- // ลดจำนวน
                itemCount.text = count.toString() // อัปเดต TextView
            }
        }

        // ตั้งค่า Listener สำหรับปุ่ม + ของเมนูหมู
        incrementButton.setOnClickListener {
            count++ // เพิ่มจำนวน
            itemCount.text = count.toString() // อัปเดต TextView
        }

        // ตั้งค่า Listener สำหรับปุ่ม - ของเมนูไก่
        decrementButton1.setOnClickListener {
            if (count1 > 0) {
                count1-- // ลดจำนวน
                itemCount1.text = count1.toString() // อัปเดต TextView
            }
        }

        // ตั้งค่า Listener สำหรับปุ่ม + ของเมนูไก่
        incrementButton1.setOnClickListener {
            count1++ // เพิ่มจำนวน
            itemCount1.text = count1.toString() // อัปเดต TextView
        }

        // ตั้งค่าปุ่มสั่งอาหาร
        val orderButton: Button = findViewById(R.id.order)
        orderButton.setOnClickListener {
            // คำนวณราคาทั้งหมด
            val totalPricePork = count * pricePork
            val totalPriceChicken = count1 * priceChicken

            // สร้าง Intent เพื่อส่งข้อมูลไปยังหน้า order
            val intent = Intent(this, order::class.java)
            intent.putExtra("food1", "หมู: $count x $pricePork = $totalPricePork บาท")
            intent.putExtra("food2", "ไก่: $count1 x $priceChicken = $totalPriceChicken บาท")
            intent.putExtra("totalPrice", totalPricePork + totalPriceChicken) // ส่งราคาทั้งหมด
            startActivity(intent)
        }
    }
}
