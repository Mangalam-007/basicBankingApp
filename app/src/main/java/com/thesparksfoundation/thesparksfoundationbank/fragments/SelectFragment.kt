package com.thesparksfoundation.thesparksfoundationbank.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.thesparksfoundation.thesparksfoundationbank.R
import com.thesparksfoundation.thesparksfoundationbank.ViewModel.AccountViewModel
import com.thesparksfoundation.thesparksfoundationbank.databinding.FragmentSelectBinding
import com.thesparksfoundation.thesparksfoundationbank.model.AccountHolder
import kotlinx.android.synthetic.main.fragment_select.*

class SelectFragment : Fragment() {
    private val args by navArgs<SelectFragmentArgs>()
    private lateinit var mAccountViewModel: AccountViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding=DataBindingUtil.inflate<FragmentSelectBinding>(inflater,R.layout.fragment_select,container,false)

       //recyclerView
        val adapter = anotherAdapter()
        val recyclerView:RecyclerView = binding.select
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        mAccountViewModel = ViewModelProvider(this).get(AccountViewModel::class.java)
        mAccountViewModel.readAllData.observe(viewLifecycleOwner,Observer{account ->
            adapter.setData(account)
        })
        return binding.root
    }
    fun equal(acc: AccountHolder):Boolean {
        val main=args.currentAccount
        if(main!=null) {
            if (main.accountNumber == acc.accountNumber) {
                return true
            } else return false
        }
        else return false
    }
}