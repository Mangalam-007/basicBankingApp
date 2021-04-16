package com.thesparksfoundation.thesparksfoundationbank.Database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.thesparksfoundation.thesparksfoundationbank.model.AccountHolder

@Dao
interface AccountHolderDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addAccount(account: AccountHolder)
    @Update
    suspend fun updateUser(account: AccountHolder)
    @Query("SELECT * FROM account_holder ORDER BY accountNumber ASC")
    fun readAllData(): LiveData<List<AccountHolder>>
}