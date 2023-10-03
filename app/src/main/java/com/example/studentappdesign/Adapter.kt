package com.example.studentappdesign

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val students: List<Student>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
        .inflate(R.layout.details_view, parent, false)
        return MyViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val student = students[position]
        holder.textName.text = "Name: ${student.name}"
        holder.textPhoneNumber.text = "Phone Number: ${student.phoneNumber}"
        holder.textAddress.text = "Address: ${student.address}"
    }

    override fun getItemCount(): Int {
        return students.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textName: TextView = itemView.findViewById(R.id.textName)
        var textPhoneNumber: TextView = itemView.findViewById(R.id.textPhoneNumber)
        var textAddress: TextView = itemView.findViewById(R.id.textAddress)
    }
}


