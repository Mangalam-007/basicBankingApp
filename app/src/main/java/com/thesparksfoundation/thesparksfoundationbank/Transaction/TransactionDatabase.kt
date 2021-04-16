package com.thesparksfoundation.thesparksfoundationbank.Transaction

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.thesparksfoundation.thesparksfoundationbank.Database.AccountHolderDao
import com.thesparksfoundation.thesparksfoundationbank.model.AccountHolder

@Database(entities=[SingleTransaction::class],version=1,exportSchema = false)
abstract class TransactionDatabase:RoomDatabase()
    {
        abstract fun transactionDao(): TransactionDao
        companion object{
            @Volatile
            private var INSTANCE: TransactionDatabase?=null
            fun getInstance(context: Context): TransactionDatabase{
                synchronized(this){
                    var instance= INSTANCE
                    if(instance==null){
                        instance= Room.databaseBuilder(
                                context.applicationContext,
                                TransactionDatabase::class.java,
                                "transaction_history_database"
                        )
                                .fallbackToDestructiveMigration()
                                .build()
                        INSTANCE=instance
                    }
                    return instance
                }
            }
        }
    }