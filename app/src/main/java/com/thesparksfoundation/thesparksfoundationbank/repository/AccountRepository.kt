package com.thesparksfoundation.thesparksfoundationbank.repository

import androidx.lifecycle.LiveData
import com.thesparksfoundation.thesparksfoundationbank.Database.AccountHolderDao
import com.thesparksfoundation.thesparksfoundationbank.model.AccountHolder

class AccountRepository(private val accountHolderDao: AccountHolderDao) {

        val readAllData: LiveData<List<AccountHolder>> = accountHolderDao.readAllData()

        suspend fun addUser(account: AccountHolder){
            accountHolderDao.addAccount(account)
        }
}