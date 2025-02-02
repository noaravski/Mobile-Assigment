package com.example.mobile_assigment2

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.mobile_assigment2.model.Student

class StudentDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_detail)


        val student = intent.getParcelableExtra<Student>("student")

        val studentImageView = findViewById<ImageView>(R.id.student_detail_image_view)
        val studentNameTextView = findViewById<TextView>(R.id.student_detail_name_text_view)
        val studentIdTextView = findViewById<TextView>(R.id.student_detail_id_text_view)
        val studentIsCheckedTextView =
            findViewById<TextView>(R.id.student_detail_is_checked_text_view)

        student?.let {
            studentImageView.setImageResource(R.drawable.avatar) // Assuming a default avatar
            studentNameTextView.text = it.name
            studentIdTextView.text = it.id
            studentIsCheckedTextView.text = it.isChecked.toString()
        }

        val editButton = findViewById<ImageButton>(R.id.EditButton)

        val index = intent.getIntExtra("student_index", -1)
        editButton.setOnClickListener {
            val intent = Intent(this, EditProfileActivity::class.java).apply {
                putExtra("student_index", index)
            }
            startActivity(intent)

        }

        val cancelButton = findViewById<ImageButton>(R.id.cancelButtonShowDetails)

        cancelButton.setOnClickListener {

            val intent = Intent(this, StudentsRecyclerViewActivity::class.java)
            startActivity(intent)
        }
    }
}