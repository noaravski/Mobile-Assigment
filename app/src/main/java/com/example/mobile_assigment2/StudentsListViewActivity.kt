package com.example.mobile_assigment2

import com.example.mobile_assigment2.adapter.StudentsAdapter
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import com.example.mobile_assigment2.model.Model
import com.example.mobile_assigment2.model.Student
import androidx.core.view.WindowInsetsCompat

class StudentsListViewActivity : AppCompatActivity() {

    var students: MutableList<Student>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_students_list_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        students = Model.shared.students
        val listView: ListView = findViewById(R.id.students_list_view)
        listView.adapter = StudentsAdapter(students)

        listView.setOnItemClickListener { parent, view, position, id ->
            Log.d("TAG", "A new row click on cell index: $position")
        }
    }
}