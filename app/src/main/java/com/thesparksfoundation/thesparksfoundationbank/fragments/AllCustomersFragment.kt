package com.thesparksfoundation.thesparksfoundationbank.fragments


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import com.thesparksfoundation.thesparksfoundationbank.R
import com.thesparksfoundation.thesparksfoundationbank.model.AccountHolder
import com.thesparksfoundation.thesparksfoundationbank.ViewModel.AccountViewModel
import com.thesparksfoundation.thesparksfoundationbank.databinding.FragmentAllCustomersBinding
import kotlinx.android.synthetic.main.fragment_all_customers.*

class AllCustomersFragment: Fragment() {
    private lateinit var mAccountViewModel: AccountViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // dataBinding
        val binding = DataBindingUtil.inflate<FragmentAllCustomersBinding>(inflater
        , R.layout.fragment_all_customers,container,false
        )

        //navigation

        //insert data
        binding.enter.setOnClickListener {
            val name:String?=binding.accountName.text.toString()
            val balance: String? =binding.balance.text.toString()
            val bal: Int? = balance?.toInt()
            val account= AccountHolder(0L, name, bal,"Yes")
            mAccountViewModel.addAccount(account)
        }
        //recyclerView
        val adapter = impoAdapter()
        val recyclerView=binding.tvResult
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        //UserViewModel
        mAccountViewModel = ViewModelProvider(this).get(AccountViewModel::class.java)
        mAccountViewModel.readAllData.observe(viewLifecycleOwner, Observer{ account ->
            adapter.setData(account)
        })

        //menu
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu,menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.
                onNavDestinationSelected(item,requireView().findNavController())
                ||super.onOptionsItemSelected(item)
    }
}