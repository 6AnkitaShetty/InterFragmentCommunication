package com.example.interfragmentcommunication

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction


class MainActivity : AppCompatActivity(), MyListener {

    private var num1 = 0
    private var num2 = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addFragmentA();
        addFragmentB();
    }

    private fun addFragmentA() {
        val fragmentA = FragmentA()
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.containerFragmentA, fragmentA, "fragA")
        transaction.commit()
    }

    private fun addFragmentB() {
        val fragmentB = FragmentB()
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.containerFragmentB, fragmentB, "fragB")
        transaction.commit()
    }

    override fun addTwoNumbers(num1: Int, num2: Int) {
        this.num1 = num1
        this.num2 = num2
        Toast.makeText(this, "Numbers Received in Activity : $num1 , $num2", Toast.LENGTH_LONG).show()
    }

    fun sendDataToFragmentB(view: View?) {
        val fragmentB = supportFragmentManager.findFragmentByTag("fragB") as FragmentB
        fragmentB.addTwoNumbers(num1, num2)
    }
}
