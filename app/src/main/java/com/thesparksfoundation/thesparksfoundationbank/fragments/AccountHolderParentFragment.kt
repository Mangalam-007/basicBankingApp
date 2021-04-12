package com.thesparksfoundation.thesparksfoundationbank.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.thesparksfoundation.thesparksfoundationbank.R
import com.thesparksfoundation.thesparksfoundationbank.databinding.FragmentAccountHolderParentBinding
import java.lang.Integer.parseInt

class AccountHolderParentFragment : Fragment() {
     private val args by navArgs<AccountHolderParentFragmentArgs>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val binding=DataBindingUtil.inflate<FragmentAccountHolderParentBinding>(inflater
       , R.layout.fragment_account_holder_parent,container,false)
        val current=args.currentAccount

        binding.name.text=args.currentAccount.accountName
        binding.number.text=args.currentAccount.accountNumber.toString()
        binding.amount.text=args.currentAccount.amount.toString()
        binding.kyc.text=args.currentAccount.kyc
       binding.transfer.setOnClickListener{
           binding.transferAmount.isVisible=true
           binding.beneficiary.isVisible=true
       }
                val balance: Int? = parseInt(binding.amount.text.toString())
        var c:Int=0;
        var amountTo:Int=0
        var amountToT = binding.transferAmount.text

//        binding.beneficiary.setOnClickListener { view:View->
//            view.findNavController().navigate(R.id.action_accountHolderParentFragment_to_selectFragment)
//        }
        binding.beneficiary.setOnClickListener {view:View->
            if(binding.beneficiary.isVisible)
            {
                if(amountToT.length>0)
                amountTo = parseInt(amountToT.toString())}
            if(amountTo == 0)
            {Toast.makeText(activity,"Enter amount", Toast.LENGTH_SHORT).show()}
            else if (amountTo != null) {
                if(amountTo!! > balance!!)
                {Toast.makeText(activity,"Insufficient Balance", Toast.LENGTH_SHORT).show()}
                else
                {
                    val action = AccountHolderParentFragmentDirections.actionAccountHolderParentFragmentToSelectFragment(current,amountTo)
                    view.findNavController().navigate(action)
                }
            }
        }
        return binding.root
    }
}