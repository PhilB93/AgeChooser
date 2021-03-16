package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val car1 = Car("car1", 2003)
        val car2 = Car("car22", 2103)
        val car3 = Car("car3", 2005)
        val car4 = Car("car4", 2007)
        val car5 = Car("car5", 2006)
        val list = mutableListOf<Car>()
        list.add(car1)
        list.add(car2)
        list.add(car3)
        list.add(car4)
        list.add(car5)

        val listView = binding.listView
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, list)
        listView.adapter = arrayAdapter
      listView.setOnItemClickListener { parent, view, position, id -> val intent = Intent(this, SecondActivity::class.java)
          startActivity(intent) }
    }
}


