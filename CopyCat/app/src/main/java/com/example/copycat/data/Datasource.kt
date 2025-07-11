package com.example.copycat.data

import com.example.copycat.R
import com.example.copycat.model.Lesson

class Datasource {
    fun loadLessons(): List<Lesson> {
        return listOf<Lesson>(
            Lesson(R.string.lesson1),
            Lesson(R.string.lesson2),
            Lesson(R.string.lesson3),
            Lesson(R.string.lesson4),
            Lesson(R.string.lesson5),
            Lesson(R.string.lesson6),
            Lesson(R.string.lesson7),
            Lesson(R.string.lesson8),
            Lesson(R.string.lesson9),
            Lesson(R.string.lesson10),
        )
    }
}