package com.hussainmukadam.cryptracker.data.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

/**
 * Created by hussain on 10/12/17.
 */

@Dao
interface CurrencyDao{

    abstract fun getCurrencyDao(): CurrencyDao

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllCurrencyData(currencyList: List<Currency>)

    @Query("SELECT * FROM currency_table")
    fun getAllCurrencyData(): List<Currency>
}