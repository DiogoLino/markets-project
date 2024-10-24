package com.ajbell.technicaltest.market.data

import android.content.Context
import com.ajbell.technicaltest.market.domain.MarketsDataSource
import com.google.gson.GsonBuilder
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

 class MarketRepository @Inject constructor(
    @ApplicationContext private val context: Context
) : MarketsDataSource {

     override suspend fun getMarkets(): GetMarketsResponse {
         val marketsJson: String = context.assets.open("markets.json")
             .bufferedReader()
             .use { it.readText() }
         return GsonBuilder().create().fromJson(marketsJson, GetMarketsResponse::class.java)
     }
 }