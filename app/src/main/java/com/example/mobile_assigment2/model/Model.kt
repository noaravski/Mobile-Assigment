package com.example.mobile_assigment2.model

class Model private constructor() {

    val students: MutableList<Student> = ArrayList()

    companion object {
        val shared = Model()
    }

    init {
        for (i in 0..5) {
            val student = Student(
                name = "name$i",
                id = "$i",
                avatarUrl = "",
                isChecked = false
            )
            students.add(student)
        }
    }
}