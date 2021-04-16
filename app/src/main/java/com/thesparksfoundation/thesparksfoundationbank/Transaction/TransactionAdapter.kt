package com.thesparksfoundation.thesparksfoundationbank.Transaction

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.thesparksfoundation.thesparksfoundationbank.R
import com.thesparksfoundation.thesparksfoundationbank.fragments.AllCustomersFragmentDirections
import com.thesparksfoundation.thesparksfoundationbank.model.AccountHolder
import kotlinx.android.synthetic.main.list_row_main.view.*
import kotlinx.android.synthetic.main.transaction_row_fragment.view.*

class TransactionAdapter:RecyclerView.Adapter<TransactionAdapter.CustomViewHolder>() {

        private var transactionList = emptyList<SingleTransaction>()

        class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view) {}

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
            return CustomViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.transaction_row_fragment, parent, false))
        }

        override fun getItemCount(): Int {
            return transactionList.size
        }


        override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
            val currentItem = transactionList[position]
            holder.itemView.sender.text = currentItem.sender
            holder.itemView.receiver.text = currentItem.receiver
            holder.itemView.amount.text  = currentItem.amount!!.toInt().toString()
            holder.itemView.status.text =currentItem.status
            holder.itemView.trans.text=currentItem.transactionNumber.toString()
//            if(holder.itemView.status.text=="Success")
//            {holder.itemView.status.setTextColor((R.color.green))}
//            else
//                holder.itemView.status.setTextColor(Color.parseColor(R.color.red.toString()))
        }
        fun setData(transaction: List<SingleTransaction>) {
            this.transactionList= transaction
            notifyDataSetChanged()
        }

}