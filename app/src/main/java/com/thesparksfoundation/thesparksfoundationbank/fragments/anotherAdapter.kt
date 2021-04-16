package com.thesparksfoundation.thesparksfoundationbank.fragments

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import com.thesparksfoundation.thesparksfoundationbank.R
import com.thesparksfoundation.thesparksfoundationbank.ViewModel.AccountViewModel
import com.thesparksfoundation.thesparksfoundationbank.model.AccountHolder
import kotlinx.android.synthetic.main.list_row_main.view.*
import kotlinx.coroutines.withContext

class anotherAdapter(var clickListener:onCarItemClickListener):RecyclerView.Adapter<anotherAdapter.CustomViewHolder>()
    {
        private var accountList = emptyList<AccountHolder>()

        class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            fun initialize(account: AccountHolder, action: onCarItemClickListener) {
                itemView.list_row.setOnClickListener {
                    action.onItemClicked(account)
                    //holder.itemView.findNavController().navigate(R.id.action_selectFragment_to_allCustomersFragment)
                }
            }
        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
            val v= CustomViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_row_main, parent, false))
            return v
        }

        override fun getItemCount(): Int {
            return accountList.size
        }

        override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
            val currentItem = accountList[position]
                holder.itemView.text_view.text = currentItem.accountName
                holder.itemView.text_view1.text = currentItem.accountNumber.toString()
            holder.initialize(currentItem,clickListener)
            //val intent=Intent(this, SelectFragment::class)

            }
        fun setData(account: List<AccountHolder>) {
            this.accountList = account
            notifyDataSetChanged()
        }
        public interface onCarItemClickListener{
            fun onItemClicked(account:AccountHolder)
        }
    }
