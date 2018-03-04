package com.hussainmukadam.cryptracker.ui.list

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import com.hussainmukadam.cryptracker.data.network.CurrencySourceService
import com.hussainmukadam.cryptracker.repo.CurrencyRepository

/**
 * Created by hussain on 10/12/17.
 */
class MainActivityViewModel(application: Application): AndroidViewModel(application) {
//    private var currencyData: LiveData<List<Currency>>
//
//    fun getCurrencyData(): LiveData<List<Currency>>{
//        currencyData
//    }

    val currencyRepository by lazy { CurrencyRepository(CurrencySourceService.getCurrencySourceService()) }

    fun getCurrencyData() = currencyRepository.getCurrencyData()
}