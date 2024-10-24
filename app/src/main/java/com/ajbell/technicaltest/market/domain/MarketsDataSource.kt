package com.ajbell.technicaltest.market.domain

import com.ajbell.technicaltest.market.data.GetMarketsResponse

interface MarketsDataSource {
    suspend fun getMarkets(): GetMarketsResponse
}