package com.hussainmukadam.cryptracker.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

/**
 *
 * Created by hussain on 10/12/17.
 */
@Database(entities = arrayOf(Currency::class), version = 1)
abstract class CurrencyDatabase : RoomDatabase() {
    abstract fun currencyDao(): CurrencyDao
}