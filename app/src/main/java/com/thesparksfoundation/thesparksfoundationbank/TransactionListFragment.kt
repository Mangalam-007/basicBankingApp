
package com.thesparksfoundation.thesparksfoundationbank

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import com.thesparksfoundation.thesparksfoundationbank.databinding.FragmentTransactionListBinding


class TransactionListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding=DataBindingUtil.inflate<FragmentTransactionListBinding>(inflater
        ,R.layout.fragment_transaction_list,container,false)

        return binding.root
    }


}