package com.thesparksfoundation.thesparksfoundationbank.Database

import android.app.Application
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AccountViewModel(application: Application): AndroidViewModel(application) {

    private val readAllData: LiveData<List<AccountHolder>>
    private val repository: AccountRepository

    init {
        val userDao = AccountDatabase.getInstance(application).accountHolderDao()
        repository = AccountRepository(userDao)
        readAllData = repository.readAllData
    }

    fun addUser(user: AccountHolder){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }

}