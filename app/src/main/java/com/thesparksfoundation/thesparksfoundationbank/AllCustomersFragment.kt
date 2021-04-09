package com.thesparksfoundation.thesparksfoundationbank

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.Adapter
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.thesparksfoundation.thesparksfoundationbank.Database.AccountDatabase
import com.thesparksfoundation.thesparksfoundationbank.Database.AccountHolder
import com.thesparksfoundation.thesparksfoundationbank.databinding.FragmentAllCustomersBinding

class AllCustomersFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentAllCustomersBinding>(inflater
        ,R.layout.fragment_all_customers,container,false
        )


        binding.accountList.setOnClickListener { view:View->
            view.findNavController().navigate(R.id.action_allCustomersFragment_to_accountHolderParentFragment)
        }
       binding.tvResult.layoutManager = LinearLayoutManager(activity)
        binding.tvResult.adapter=MainAdapter()
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