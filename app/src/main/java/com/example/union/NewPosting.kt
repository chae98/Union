package com.example.union

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.time.LocalDate

class NewPosting : AppCompatActivity() {

    private var calendar = Calendar.getInstance()
    private var year = calendar.get(Calendar.YEAR)
    private var month = calendar.get(Calendar.MONTH)
    private var day = calendar.get(Calendar.DAY_OF_MONTH)



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_posting)



        var img_dialog = findViewById<ImageView>(R.id.img_dialog)
        var tv_date = findViewById<TextView>(R.id.tv_date)

        currentDate(tv_date)

        img_dialog.setOnClickListener{
            val datePickerDialog =  DatePickerDialog(this, { _, year, month, day ->
                tv_date.text = year.toString() + "-" + month.toString() + "-" + day.toString()
            }, year, month, day)
            datePickerDialog.show()
        }
    }
    fun currentDate(date: TextView){
        val datetime = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            LocalDate.now()
        } else {
            TODO("VERSION.SDK_INT < O")
        }
        date.text = datetime.toString()
    }


}