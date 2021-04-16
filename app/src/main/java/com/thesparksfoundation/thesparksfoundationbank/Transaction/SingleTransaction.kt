package com.thesparksfoundation.thesparksfoundationbank.Transaction

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName="transaction_holder")
data class SingleTransaction (
        @PrimaryKey(autoGenerate = true)
        var transactionNumber:Long = 0L,

        @ColumnInfo(name="sender")
        var sender:String? = null,

        @ColumnInfo(name="receiver")
        var receiver:String?=null,

        @ColumnInfo(name="amount")
        var amount:Int?=0,

        @ColumnInfo(name="status")
        var status:String?=null
): Parcelable