package com .thesparksfoundation.thesparksfoundationbank

import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.thesparksfoundation.thesparksfoundationbank.databinding.ActivityMainBinding.inflate

class MainAdapter: RecyclerView.Adapter<CustomViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater=LayoutInflater.from(parent?.context)
        val cellForFlow=layoutInflater.inflate(R.layout.list_row_main,parent,false)
        return CustomViewHolder(cellForFlow)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val te:TextView?=holder?.view?.findViewById(R.id.text_view)
        //te?.text  ="123"
    }

}

class CustomViewHolder(val view:View):RecyclerView.ViewHolder(view) {

}
