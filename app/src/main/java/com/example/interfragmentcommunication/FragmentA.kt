package com.example.interfragmentcommunication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_a.*


/**
 * A simple [Fragment] subclass.
 */
class FragmentA : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_a, container, false)

        val btnSend = view.findViewById(R.id.btnSend) as Button
        btnSend.setOnClickListener { sendData() }
        return view
    }

    private fun sendData() {
        val firstNum: Int = Integer.valueOf(etFirstNumber.text.toString())
        val secondNum: Int = Integer.valueOf(etSecondNumber.text.toString())
        val myListener = activity as MyListener?
        myListener!!.addTwoNumbers(firstNum, secondNum)
    }
}
