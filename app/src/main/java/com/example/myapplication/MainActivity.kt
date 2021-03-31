package com.example.myapplication

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.myapplication.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*
import javax.xml.datatype.DatatypeConstants.MONTHS

class MainActivity : AppCompatActivity() {
   private  lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    binding.btnAge.setOnClickListener {
        ageChooser(it)
        Toast.makeText(this, "Hi!", Toast.LENGTH_SHORT).show() }
    }

    //Календарь
    @SuppressLint("SetTextI18n")
    private fun ageChooser(view: View) {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)


          val dpd =  DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, sYear, sMonth, sDayOfMonth ->
            val selectedDate = "$sDayOfMonth.${sMonth+1}.$sYear"

                binding.textDate.text = selectedDate
                val sdf = SimpleDateFormat("dd.MM.yyyy", Locale.US)
                val theDate = sdf.parse(selectedDate)
                val dateInDays = theDate!!.time/86400000
                val currentTime = sdf.parse(sdf.format(System.currentTimeMillis()))
                val curDay = currentTime!!.time/86400000
                val difference = curDay  - dateInDays
                binding.textAgeInMin.text = difference.toString()
            }
                , year
                , month
                , day)

        dpd.datePicker.maxDate = Date().time
        dpd.show()

        }



}


