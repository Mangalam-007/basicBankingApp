package com.thesparksfoundation.thesparksfoundationbank.Transaction

import androidx.lifecycle.LiveData

class TransactionRepository(private val transactionDao: TransactionDao) {

        val readAllData: LiveData<List<SingleTransaction>> = transactionDao.readAllData()

        suspend fun addUser(transaction: SingleTransaction){
            transactionDao.addTransaction(transaction)

        }
    }