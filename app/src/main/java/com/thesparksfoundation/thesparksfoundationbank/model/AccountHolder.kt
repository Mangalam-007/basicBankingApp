package com.thesparksfoundation.thesparksfoundationbank.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName="account_holder")
data class AccountHolder (
        @PrimaryKey(autoGenerate = true)
        var accountNumber:Long = 258697412L,

        @ColumnInfo(name="account_name")
        var accountName:String? = null,

        @ColumnInfo(name="amount")
        var amount:Int?=0,

        @ColumnInfo(name="KYC updated")
        var kyc:String="Yes",
): Parcelable