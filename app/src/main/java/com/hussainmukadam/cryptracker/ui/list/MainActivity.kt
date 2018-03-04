package com.hussainmukadam.cryptracker.ui.list

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.hussainmukadam.cryptracker.R
import com.hussainmukadam.cryptracker.adapter.CurrencyDataAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = CurrencyDataAdapter()
        rv_currency_list.layoutManager = LinearLayoutManager(this)
        rv_currency_list.adapter = adapter

        val mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)

        mainActivityViewModel.getCurrencyData().observe(this, Observer {
            it?.body?.let { adapter.swapList(it) }
        })
    }
}
