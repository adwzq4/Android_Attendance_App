package edu.umsl.cs4020_project1_adamwilson

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        classOneButton.text = getClassDetails(0)
        classTwoButton.text = getClassDetails(1)
        classThreeButton.text = getClassDetails(2)

        classOneButton.setOnClickListener{
            val intent = Intent(this, AttendanceActivity::class.java)
            intent.putExtra("class", "0")
            startActivity(intent)
        }

        classTwoButton.setOnClickListener{
            val intent = Intent(this@MainActivity, AttendanceActivity::class.java)
            intent.putExtra("class", "1")
            startActivity(intent)
        }

        classThreeButton.setOnClickListener{
            val intent = Intent(this@MainActivity, AttendanceActivity::class.java)
            intent.putExtra("class", "2")
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        classOneButton.text = getClassDetails(0)
        classTwoButton.text = getClassDetails(1)
        classThreeButton.text = getClassDetails(2)
    }

    private fun getClassDetails(i: Int): String{
        var numPresent = 0
        var numLate = 0
        var numAbsent = 0
        var numUnknown = 0
        val classSize: Int = ClassModel.sections[i].numStudents

        for (student in ClassModel.sections[i].studentRoster){
            when (student.status) {
                "Present" -> numPresent++
                "Late" -> numLate++
                "Absent" -> numAbsent++
                "Unknown" -> numUnknown++
            }
        }

        return getString(R.string.classDetails).format(
            ClassModel.sections[i].className,
            ClassModel.sections[i].days,
            classSize,
            numPresent.toDouble() / classSize * 100,
            numLate.toDouble() / classSize * 100,
            numAbsent.toDouble() / classSize * 100,
            numUnknown.toDouble() / classSize * 100
        )
    }
}