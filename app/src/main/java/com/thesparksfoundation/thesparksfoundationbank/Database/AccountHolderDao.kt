package com.thesparksfoundation.thesparksfoundationbank.Database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface AccountHolderDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(account: AccountHolder)
    @Update
    suspend fun update(account: AccountHolder)
    @Query("SELECT * FROM account_holder ORDER BY accountNumber ASC")
    fun readAllData(): LiveData<List<AccountHolder>>
}