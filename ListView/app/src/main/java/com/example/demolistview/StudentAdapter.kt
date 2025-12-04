package com.example.demolistview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class StudentAdapter(
    private val context: Context,
    private val students: List<Student>
) : BaseAdapter() {

    override fun getCount(): Int = students.size

    override fun getItem(position: Int): Student = students[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.item_student, parent, false)

        val student = getItem(position)

        val textViewName: TextView = view.findViewById(R.id.textViewName)
        val textViewId: TextView = view.findViewById(R.id.textViewId)
        val textViewClass: TextView = view.findViewById(R.id.textViewClass)
        val textViewGrade: TextView = view.findViewById(R.id.textViewGrade)

        textViewName.text = student.name
        textViewId.text = "MSSV: ${student.studentId}"
        textViewClass.text = "Lớp: ${student.className}"
        textViewGrade.text = student.grade.toString()

        return view
    }
}

