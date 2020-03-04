package edu.umsl.cs4020_project1_adamwilson

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_attendance.*

class AttendanceActivity : AppCompatActivity() {
    var i: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_attendance)

        i = intent.getStringExtra("class")?.toInt() ?: -1

        className.text = ClassModel.sections[i].className

        resetButton.setOnClickListener{
            for (student in ClassModel.sections[i].studentRoster){
                student.status = "Unknown"
            }
            studentAttendanceRecyclerView.adapter!!.notifyDataSetChanged()
        }

        studentAttendanceRecyclerView.layoutManager = LinearLayoutManager(this)
        studentAttendanceRecyclerView.adapter = AttendanceAdapter()
    }

    inner class AttendanceAdapter : RecyclerView.Adapter<AttendanceAdapter.AttendanceSelectorHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AttendanceSelectorHolder {
            val inflater = LayoutInflater.from(this@AttendanceActivity)
            val itemView = inflater.inflate(R.layout.attendance_selector_layout, parent, false)
            return AttendanceSelectorHolder(itemView)
        }

        override fun getItemCount(): Int = ClassModel.sections[i].numStudents

        override fun onBindViewHolder(holder: AttendanceSelectorHolder, position: Int) {
            val student = ClassModel.sections[i].studentRoster[position]
            holder.bindStudent(student)
            holder.presentRadioButton.setOnClickListener{
                ClassModel.sections[i].studentRoster[position].status = "Present"
            }
            holder.lateRadioButton.setOnClickListener{
                ClassModel.sections[i].studentRoster[position].status = "Late"
            }
            holder.absentRadioButton.setOnClickListener{
                ClassModel.sections[i].studentRoster[position].status = "Absent"
            }
            holder.unknownRadioButton.setOnClickListener{
                ClassModel.sections[i].studentRoster[position].status = "Unknown"
            }
        }

        inner class AttendanceSelectorHolder constructor(itemView: View): RecyclerView.ViewHolder(itemView){
            private val studentNameView: TextView = itemView.findViewById((R.id.studentNameView))
            val presentRadioButton: RadioButton = itemView.findViewById(R.id.presentRadioButton)
            val lateRadioButton: RadioButton = itemView.findViewById(R.id.lateRadioButton)
            val absentRadioButton: RadioButton = itemView.findViewById(R.id.absentRadioButton)
            val unknownRadioButton: RadioButton = itemView.findViewById(R.id.unknownRadioButton)

            fun bindStudent(student: Student){
                studentNameView.text = student.name

                when (student.status){
                    "Present" -> presentRadioButton.isChecked = true
                    "Late" -> lateRadioButton.isChecked = true
                    "Absent" -> absentRadioButton.isChecked = true
                    "Unknown" -> unknownRadioButton.isChecked = true
                }
            }
        }
    }
}