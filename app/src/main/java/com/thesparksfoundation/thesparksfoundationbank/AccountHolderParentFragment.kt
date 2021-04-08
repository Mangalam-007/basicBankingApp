package com.thesparksfoundation.thesparksfoundationbank

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.thesparksfoundation.thesparksfoundationbank.databinding.FragmentAccountHolderParentBinding


class AccountHolderParentFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val binding=DataBindingUtil.inflate<FragmentAccountHolderParentBinding>(inflater
       ,R.layout.fragment_account_holder_parent,container,false)
        binding.beneficiaryHolder.setOnClickListener { view:View->
            view.findNavController().navigate(R.id.action_accountHolderParentFragment_to_selectFragment)
        }
        return binding.root
    }
}