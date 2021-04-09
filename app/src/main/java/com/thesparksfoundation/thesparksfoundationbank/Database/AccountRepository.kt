package com.thesparksfoundation.thesparksfoundationbank.Database

import android.provider.SyncStateContract.Helpers.insert
import androidx.lifecycle.LiveData

class AccountRepository(private val accountHolderDao: AccountHolderDao) {

        val readAllData: LiveData<List<AccountHolder>> = accountHolderDao.readAllData()

        suspend fun addUser(account: AccountHolder){
            accountHolderDao.addUser(account)
        }

}