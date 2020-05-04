package com.example.top100crypto.rest

import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*
import com.example.top100crypto.rest.GeckoCoin
import io.reactivex.Observable
import retrofit2.http.Path

interface CoinGeckoApi {
    @GET("coins/markets")
    fun getCoinMarket(
        @Query("vs_currency") vs: String = "usd",
        @Query("order") order: String = "market_cap_desc",
        @Query("per_page") perPage: Int = 100,
        @Query("sparkline") sparkline: Boolean = false
    ): Observable<List<GeckoCoin>>

    @GET("coins/{id}/market_chart")
    fun getCoinMarketChart(
        @Path("id") id: String,
        @Query("vs_currency") vsCurrency: String = "usd",
        @Query("days") days: String = "max"
    ): Observable<GeckoCoinChart>
}