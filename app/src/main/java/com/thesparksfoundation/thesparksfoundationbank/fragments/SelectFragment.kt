package com.thesparksfoundation.thesparksfoundationbank.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.thesparksfoundation.thesparksfoundationbank.R
import com.thesparksfoundation.thesparksfoundationbank.Transaction.SingleTransaction
import com.thesparksfoundation.thesparksfoundationbank.Transaction.TransactionViewModel
import com.thesparksfoundation.thesparksfoundationbank.ViewModel.AccountViewModel
import com.thesparksfoundation.thesparksfoundationbank.databinding.FragmentSelectBinding
import com.thesparksfoundation.thesparksfoundationbank.model.AccountHolder

class SelectFragment()  : Fragment(), anotherAdapter.onCarItemClickListener {
    private val args by navArgs<SelectFragmentArgs>()
    private lateinit var mAccountViewModel: AccountViewModel
    private lateinit var mTransactionViewModel: TransactionViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding=DataBindingUtil.inflate<FragmentSelectBinding>(inflater,R.layout.fragment_select,container,false)

       //recyclerView
        val adapter = anotherAdapter(this)
        val recyclerView:RecyclerView = binding.select
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        mTransactionViewModel=ViewModelProvider(this).get(TransactionViewModel::class.java)
        mAccountViewModel = ViewModelProvider(this).get(AccountViewModel::class.java)
        mAccountViewModel.readAllData.observe(viewLifecycleOwner,Observer{account ->
            adapter.setData(account)
        })
        binding.cancel.setOnClickListener {
            val transaction= SingleTransaction(0L, args.currentAccount.accountName, "Not selected", args.amountTo,"Failure")
            mTransactionViewModel.addTransaction(transaction)
            Toast.makeText(context,"Transaction failed",Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_selectFragment_to_allCustomersFragment)
        }
        return binding.root
    }
//    fun equal(acc: AccountHolder):Boolean {
//        val main=args.currentAccount
//        if(main!=null) {
//            if (main.accountNumber == acc.accountNumber) {
//                return true
//            } else return false
//        }
//        else return false
//    }
    override fun onItemClicked(account: AccountHolder) {
        val amo=args.amountTo
        val amountr= account.amount?.plus(amo)
        val receiver=AccountHolder(account.accountNumber,account.accountName,amountr,account.kyc)
        mAccountViewModel.updateUser(receiver)
        val r=args.currentAccount
        val amountg:Int?= r.amount?.minus(amo)
        val giver=AccountHolder(r.accountNumber,r.accountName,amountg,r.kyc)
        //update current holder
        mAccountViewModel.updateUser(giver)
        Toast.makeText(context,"Transaction successful",Toast.LENGTH_LONG).show()
        val transaction= SingleTransaction(0L, r.accountName, account.accountName, amo,"Success")
        mTransactionViewModel.addTransaction(transaction)
        findNavController().navigate(R.id.action_selectFragment_to_allCustomersFragment)
    }
}