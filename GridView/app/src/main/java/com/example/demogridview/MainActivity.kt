package com.example.demogridview

import android.graphics.Color
import android.os.Bundle
import android.widget.GridView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.demo_gridview)
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Tạo dữ liệu mẫu cho GridView
        val gridItems = listOf(
            GridItem("Item 1", Color.parseColor("#FF6B6B")),
            GridItem("Item 2", Color.parseColor("#4ECDC4")),
            GridItem("Item 3", Color.parseColor("#45B7D1")),
            GridItem("Item 4", Color.parseColor("#FFA07A")),
            GridItem("Item 5", Color.parseColor("#98D8C8")),
            GridItem("Item 6", Color.parseColor("#F7DC6F")),
            GridItem("Item 7", Color.parseColor("#BB8FCE")),
            GridItem("Item 8", Color.parseColor("#85C1E2")),
            GridItem("Item 9", Color.parseColor("#F8B88B")),
            GridItem("Item 10", Color.parseColor("#AED6F1")),
            GridItem("Item 11", Color.parseColor("#A9DFBF")),
            GridItem("Item 12", Color.parseColor("#F9E79F"))
        )

        // Thiết lập GridView
        val gridView: GridView = findViewById(R.id.gridView)
        val adapter = GridAdapter(this, gridItems)
        gridView.adapter = adapter

        // Xử lý sự kiện click trên item
        gridView.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = gridItems[position]
            Toast.makeText(
                this,
                "Bạn đã chọn: ${selectedItem.title}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}