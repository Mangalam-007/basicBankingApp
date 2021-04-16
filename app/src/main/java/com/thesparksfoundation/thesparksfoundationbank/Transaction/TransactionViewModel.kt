package com.thesparksfoundation.thesparksfoundationbank.Transaction

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.thesparksfoundation.thesparksfoundationbank.Database.AccountDatabase
import com.thesparksfoundation.thesparksfoundationbank.model.AccountHolder
import com.thesparksfoundation.thesparksfoundationbank.repository.AccountRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TransactionViewModel(application: Application):AndroidViewModel(application) {

        val readAllData: LiveData<List<SingleTransaction>>
        private val repository: TransactionRepository

        init {
            val transactionDao = TransactionDatabase.getInstance(application).transactionDao()
            repository = TransactionRepository(transactionDao)
            readAllData = repository.readAllData
        }

        fun addTransaction(transaction: SingleTransaction){
            viewModelScope.launch(Dispatchers.IO) {
                repository.addUser(transaction)
            }
        }
}