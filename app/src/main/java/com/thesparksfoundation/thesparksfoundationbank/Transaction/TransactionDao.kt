package com.thesparksfoundation.thesparksfoundationbank.Transaction

import androidx.lifecycle.LiveData
import androidx.room.*
import com.thesparksfoundation.thesparksfoundationbank.model.AccountHolder
@Dao
interface TransactionDao {
        @Insert(onConflict = OnConflictStrategy.IGNORE)
        suspend fun addTransaction(transaction: SingleTransaction)
        @Query("SELECT * FROM transaction_holder ORDER BY transactionNumber DESC")
        fun readAllData(): LiveData<List<SingleTransaction>>
}