package com.thesparksfoundation.thesparksfoundationbank.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.thesparksfoundation.thesparksfoundationbank.Database.AccountDatabase
import com.thesparksfoundation.thesparksfoundationbank.repository.AccountRepository
import com.thesparksfoundation.thesparksfoundationbank.model.AccountHolder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AccountViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<AccountHolder>>
    private val repository: AccountRepository

    init {
        val accountHolderDao = AccountDatabase.getInstance(application).accountHolderDao()
        repository = AccountRepository(accountHolderDao)
        readAllData = repository.readAllData
    }

    fun addAccount(account: AccountHolder){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(account)
        }
    }

    fun updateUser(account: AccountHolder){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateUser(account)
        }
    }
}