package com.example.studentappdesign

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val students = mutableListOf<Student>()
    private lateinit var recyclerView: RecyclerView
    private lateinit var button1: Button
    private lateinit var editName: EditText
    private lateinit var editPhoneNumber: EditText
    private lateinit var editAddress: EditText
    private lateinit var button2: Button
    private lateinit var adapter: MyAdapter
    private lateinit var frontLayout: RelativeLayout
    private lateinit var formLayout: LinearLayout


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)


        editName = findViewById(R.id.textName)
        editPhoneNumber = findViewById(R.id.textPhoneNumber)
        editAddress = findViewById(R.id.textAddress)
        frontLayout = findViewById(R.id.l1)
        formLayout = findViewById(R.id.l2)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.buttonAdd)


        adapter = MyAdapter(students)
        recyclerView.adapter = adapter

        button1.setOnClickListener {
            formLayout.visibility = View.VISIBLE
            frontLayout.visibility = View.GONE

        }

        button2.setOnClickListener {
            recyclerView.visibility = View.VISIBLE
            frontLayout.visibility = View.VISIBLE
            formLayout.visibility = View.GONE
            val name = editName.text.toString()
            val phoneNumber = editPhoneNumber.text.toString()
            val address = editAddress.text.toString()

            if (name.isNotEmpty() && phoneNumber.isNotEmpty() && address.isNotEmpty()) {
                val student = Student(name, phoneNumber, address)
                students.add(student)
                adapter.notifyDataSetChanged()
                clearForm()
            }



        }
    }

    private fun clearForm() {
        editName.text.clear()
        editPhoneNumber.text.clear()
        editAddress.text.clear()
    }




}

