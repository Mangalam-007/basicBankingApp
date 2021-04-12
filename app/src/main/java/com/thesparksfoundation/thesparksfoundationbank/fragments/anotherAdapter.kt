package com.thesparksfoundation.thesparksfoundationbank.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.thesparksfoundation.thesparksfoundationbank.R
import com.thesparksfoundation.thesparksfoundationbank.model.AccountHolder
import kotlinx.android.synthetic.main.list_row_main.view.*

class anotherAdapter:RecyclerView.Adapter<anotherAdapter.CustomViewHolder>()
    {

        private var accountList = emptyList<AccountHolder>()

        class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view) {}

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
            return CustomViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_row_main, parent, false))
        }

        override fun getItemCount(): Int {
            return accountList.size
        }

        override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
            val currentItem = accountList[position]
                holder.itemView.text_view.text = currentItem.accountName
                holder.itemView.text_view1.text = currentItem.accountNumber.toString()
                holder.itemView.list_row.setOnClickListener {
                    holder.itemView.findNavController().navigate(R.id.action_selectFragment_to_allCustomersFragment)
                }
        }
        fun setData(account: List<AccountHolder>) {
            this.accountList = account
            notifyDataSetChanged()
        }
    }
