package com.hussainmukadam.cryptracker.repo

import com.hussainmukadam.cryptracker.data.network.CurrencySourceService

/**
 * Created by hussain on 03/03/18.
 */
class CurrencyRepository(val currencySourceService: CurrencySourceService) {


    fun getCurrencyData() = currencySourceService.getCurrencySource()
}