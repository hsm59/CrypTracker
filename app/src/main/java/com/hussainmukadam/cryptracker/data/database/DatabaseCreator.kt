package com.hussainmukadam.cryptracker.data.database

import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

/**
 * Created by hussain on 10/12/17.
 */
object DatabaseCreator {

    lateinit var database: CurrencyDatabase

    operator fun invoke(context: Context): DatabaseCreator{
        database = Room.databaseBuilder(context, CurrencyDatabase::class.java, "currency-db").build()
        return this
    }
}