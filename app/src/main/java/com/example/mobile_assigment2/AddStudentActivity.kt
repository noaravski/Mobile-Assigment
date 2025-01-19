package com.example.mobile_assigment2

import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import com.example.mobile_assigment2.adapter.StudentsAdapter
import com.example.mobile_assigment2.model.Model
import com.example.mobile_assigment2.model.Student

class AddStudentActivity : AppCompatActivity() {
    var saveButton: Button? = null
    var cancelButton: Button? = null
    var nameTextField: EditText? = null
    var idTextField: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_student)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        saveButton = findViewById(R.id.add_student_activity_save_button)
        cancelButton = findViewById(R.id.add_student_activity_cancel_button)
        nameTextField = findViewById(R.id.add_student_activity_name_edit_text)
        idTextField = findViewById(R.id.add_student_activity_id_edit_text)

        saveButton?.setOnClickListener {
            val student = Student(
                name = "Name: " + nameTextField?.text.toString(),
                id = "Student ID: " + idTextField?.text.toString(),
                avatarUrl = "",
                isChecked = false
            )
            Log.d("AddStudentActivity", "Student: $student")
            Log.d("AddStudentActivity", "Model.shared.students: ${Model.shared.students}")
            Model.shared.students.add(student)

            val intent = Intent(this, StudentsRecyclerViewActivity::class.java)
            startActivity(intent)
        }

        cancelButton?.setOnClickListener {
            finish()
        }
    }
}