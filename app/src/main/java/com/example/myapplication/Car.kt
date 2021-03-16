package com.example.myapplication

class Car(private val name:String, private val year:Int) {

    override fun toString(): String {
        return "Car(name='$name', year=$year)"
    }
}