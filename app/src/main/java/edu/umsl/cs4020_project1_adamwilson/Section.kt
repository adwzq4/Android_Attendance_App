package edu.umsl.cs4020_project1_adamwilson

data class Section(
    val className: String,
    val days: String,
    var numStudents: Int,
    var studentRoster: List<Student>
)