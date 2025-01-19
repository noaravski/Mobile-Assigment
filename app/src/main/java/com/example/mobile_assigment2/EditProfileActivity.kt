package com.example.mobile_assigment2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.mobile_assigment2.model.Model
import com.example.mobile_assigment2.model.Student

class EditProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)


        val saveButton = findViewById<Button>(R.id.save_button)
        val cancelButton = findViewById<Button>(R.id.cancel_button)
        val deleteButton = findViewById<Button>(R.id.delete_button)

        saveButton.setOnClickListener {

            val nameTextField = findViewById<EditText>(R.id.edit_name).text.toString()
            val idTextField = findViewById<EditText>(R.id.edit_id).text.toString()
            val isCheckedCheckBox = findViewById<CheckBox>(R.id.edit_is_checked).isChecked


            val index = intent.getIntExtra("student_index", -1)
            val updatedStudent = Student(
                name = nameTextField,
                id = idTextField,
                avatarUrl = "",
                isChecked = isCheckedCheckBox
            )
            Log.d("TAG", "before Update student: " + Model.shared.students[index])
            Model.shared.students[index] = updatedStudent
            Log.d("TAG", "Update student: " + Model.shared.students[index])
            goHome()
        }

        cancelButton.setOnClickListener {
            goHome()
        }

        deleteButton.setOnClickListener {
            val index = intent.getIntExtra("student_index", -1)
            Model.shared.students.removeAt(index)
            goHome()
        }

    }

    fun goHome() {
        val intent = Intent(this, StudentsRecyclerViewActivity::class.java)
        startActivity(intent)
    }
}