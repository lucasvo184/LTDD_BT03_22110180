package com.example.demolistview

import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.demo_listview)
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Tạo danh sách sinh viên mẫu
        val students = listOf(
            Student("Nguyễn Văn An", "SV001", "IT001", 8.5),
            Student("Trần Thị Bình", "SV002", "IT001", 9.0),
            Student("Lê Văn Cường", "SV003", "IT002", 7.5),
            Student("Phạm Thị Dung", "SV004", "IT002", 8.8),
            Student("Hoàng Văn Em", "SV005", "IT003", 9.2),
            Student("Vũ Thị Phương", "SV006", "IT003", 8.0),
            Student("Đặng Văn Giang", "SV007", "IT001", 7.8),
            Student("Bùi Thị Hoa", "SV008", "IT002", 9.5),
            Student("Ngô Văn Hùng", "SV009", "IT003", 8.3),
            Student("Đỗ Thị Lan", "SV010", "IT001", 8.7)
        )

        // Tạo adapter và gán cho ListView
        val listView: ListView = findViewById(R.id.listView)
        val adapter = StudentAdapter(this, students)
        listView.adapter = adapter

        // Xử lý sự kiện click trên item
        listView.setOnItemClickListener { parent, view, position, id ->
            val selectedStudent = students[position]
            Toast.makeText(
                this,
                "Đã chọn: ${selectedStudent.name}\nĐiểm: ${selectedStudent.grade}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}