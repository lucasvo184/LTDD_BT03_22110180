package com.example.demorecycleview

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.demo_recycleview)
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Tạo dữ liệu mẫu
        val items = listOf(
            ItemData(
                title = "Android Development",
                description = "Học lập trình Android với Kotlin và Java"
            ),
            ItemData(
                title = "RecyclerView Tutorial",
                description = "Hướng dẫn sử dụng RecyclerView trong Android"
            ),
            ItemData(
                title = "Material Design",
                description = "Thiết kế giao diện với Material Design Components"
            ),
            ItemData(
                title = "Kotlin Programming",
                description = "Ngôn ngữ lập trình Kotlin cho Android"
            ),
            ItemData(
                title = "Jetpack Compose",
                description = "Xây dựng UI hiện đại với Jetpack Compose"
            ),
            ItemData(
                title = "Room Database",
                description = "Lưu trữ dữ liệu local với Room Database"
            ),
            ItemData(
                title = "Retrofit API",
                description = "Kết nối với REST API sử dụng Retrofit"
            ),
            ItemData(
                title = "MVVM Architecture",
                description = "Kiến trúc MVVM trong Android development"
            ),
            ItemData(
                title = "Coroutines",
                description = "Xử lý bất đồng bộ với Kotlin Coroutines"
            ),
            ItemData(
                title = "Navigation Component",
                description = "Điều hướng giữa các màn hình với Navigation Component"
            )
        )

        // Thiết lập RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        
        val adapter = ItemAdapter(items) { item ->
            // Xử lý khi click vào item
            Toast.makeText(
                this,
                "Bạn đã chọn: ${item.title}",
                Toast.LENGTH_SHORT
            ).show()
        }
        
        recyclerView.adapter = adapter
    }
}