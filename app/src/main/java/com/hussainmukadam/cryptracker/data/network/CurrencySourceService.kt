package com.hussainmukadam.cryptracker.data.network

import android.arch.lifecycle.LiveData
import com.hussainmukadam.cryptracker.data.database.Currency
import com.hussainmukadam.cryptracker.utilities.LiveDataCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * Created by hussain on 03/03/18.
 */
interface CurrencySourceService {

    /**
     * Retrieves all the latest currency data from Coin Market Cap
     */
    @GET("ticker/?limit=30")
    fun getCurrencySource(): LiveData<ApiResponse<List<Currency>>>

    companion object Factory {
        val BASE_URL = "https://api.coinmarketcap.com/v1/"

        val interceptor : HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }

        val client : OkHttpClient = OkHttpClient.Builder().apply {
            this.addInterceptor(interceptor)
        }.build()


        fun getCurrencySourceService(): CurrencySourceService {
            return Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(LiveDataCallAdapterFactory())
                    .client(client)
                    .build()
                    .create(CurrencySourceService::class.java)
        }
    }
}
