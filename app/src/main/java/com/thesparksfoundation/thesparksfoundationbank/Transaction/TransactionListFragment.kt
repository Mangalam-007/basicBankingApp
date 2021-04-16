
package com.thesparksfoundation.thesparksfoundationbank.Transaction

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.thesparksfoundation.thesparksfoundationbank.R
import com.thesparksfoundation.thesparksfoundationbank.databinding.FragmentTransactionListBinding
import com.thesparksfoundation.thesparksfoundationbank.fragments.impoAdapter


class TransactionListFragment : Fragment() {
     lateinit var mTransactionViewModel:TransactionViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding=DataBindingUtil.inflate<FragmentTransactionListBinding>(inflater
        , R.layout.fragment_transaction_list,container,false)
        val adapter = TransactionAdapter()
        val recyclerView=binding.tra
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        mTransactionViewModel= ViewModelProvider(this).get(TransactionViewModel::class.java)
        mTransactionViewModel.readAllData.observe(viewLifecycleOwner, Observer{account ->
            adapter.setData(account)
        })
        return binding.root
    }


}