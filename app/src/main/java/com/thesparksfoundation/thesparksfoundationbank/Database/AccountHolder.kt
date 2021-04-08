package com.thesparksfoundation.thesparksfoundationbank.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="account_holder")
data class AccountHolder (

        @PrimaryKey(autoGenerate = false)
        var accountNumber:Long = 0L,

        @ColumnInfo(name="account_name")
        var accountName:String? = null,

        @ColumnInfo(name="amount")
        var amount:Int=0,

        @ColumnInfo(name="KYC updated")
        var kyc:String="Yes",
)