package com.hussainmukadam.cryptracker.adapter

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hussainmukadam.cryptracker.R
import com.hussainmukadam.cryptracker.data.database.Currency
import kotlinx.android.synthetic.main.currency_item.view.*

/**
 * Created by hussain on 03/03/18.
 */

class CurrencyDataAdapter : RecyclerView.Adapter<CurrencyDataAdapter.CurrencyHolder>() {

    private var currencyList : List<Currency> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CurrencyHolder(LayoutInflater.from(parent.context).inflate(R.layout.currency_item, parent, false))

    override fun onBindViewHolder(holder: CurrencyHolder, position: Int) {
        Log.d("", "Inside bind view holder "+currencyList[position])
        holder.bind(currencyList[position])
    }

    override fun getItemCount() = currencyList.size

    class CurrencyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        /**
         * Binds the UI with the data and handles clicks
         */
        fun bind(currencyData: Currency) = with(itemView) {
            tv_currency_name.text = currencyData.name
            tv_currency_price.text = currencyData.priceUsd
            tv_currency_last_updated.text = currencyData.lastUpdated
            tv_currency_symbol.text = currencyData.symbol
        }
    }

    fun swapList(currencyList: List<Currency>) {
        this.currencyList = currencyList
        notifyDataSetChanged()
    }
}