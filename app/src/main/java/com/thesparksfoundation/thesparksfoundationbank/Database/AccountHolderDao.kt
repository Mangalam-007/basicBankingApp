package com.thesparksfoundation.thesparksfoundationbank.Database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Update

@Dao
interface AccountHolderDao {
    @Insert
    suspend fun insert(account: AccountHolder)
    @Update
    suspend fun update(night: AccountHolder)
}