package com.example.mobile_assigment2.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobile_assigment2.model.Student
import com.example.mobile_assigment2.R
import com.example.mobile_assigment2.StudentDetailActivity

class StudentsAdapter(private val students: MutableList<Student>?) : BaseAdapter() {

    override fun getCount(): Int = students?.size ?: 0


    override fun getItem(position: Int): Any? = students?.get(position)

    override fun getItemId(position: Int): Long = 0

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflation = LayoutInflater.from(parent?.context)
        val view = convertView ?: inflation.inflate(R.layout.student_list_row, parent, false)


        val student = students?.get(position)

        val nameTextView: TextView? = view?.findViewById(R.id.student_row_name_text_view)
        val idTextView: TextView? = view?.findViewById(R.id.student_row_id_text_view)
        val studentCheckBox: CheckBox? = view?.findViewById(R.id.student_row_check_box)

        nameTextView?.text = student?.name
        idTextView?.text = student?.id

        studentCheckBox?.apply {
            isChecked = student?.isChecked ?: false
            tag = position
        }

        view?.setOnClickListener {
            val context = view.context
            val intent = Intent(context, StudentDetailActivity::class.java)
            intent.putExtra("student", student)
            context.startActivity(intent)
        }

        return view!!
//        val view = convertView ?: inflation.inflate(
//            R.layout.student_list_row, parent, false
//        ).apply {
//            findViewById<CheckBox>(R.id.student_row_check_box).apply {
//                setOnClickListener { view ->
//                    (tag as? Int)?.let { tag ->
//                        val student = students?.get(tag)
//                        student?.isChecked = (view as? CheckBox)?.isChecked ?: false
//                    }
//                }
//            }
//        }
//
//
//        val student = students?.get(position)
//
//        val nameTextView: TextView? = view?.findViewById(R.id.student_row_name_text_view)
//        val idTextView: TextView? = view?.findViewById(R.id.student_row_id_text_view)
//        val studentCheckBox: CheckBox? = view?.findViewById(R.id.student_row_check_box)
//
//        nameTextView?.text = student?.name
//        idTextView?.text = student?.id
//
//        studentCheckBox?.apply {
//            isChecked = student?.isChecked ?: false
//            tag = position
//        }
//
//        return view!!
    }
}
