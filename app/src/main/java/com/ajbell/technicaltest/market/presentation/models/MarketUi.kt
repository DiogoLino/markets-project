package com.ajbell.technicaltest.market.presentation.models

import com.ajbell.technicaltest.market.data.GetMarketsResponse

data class MarketUi(
    val epic: String,
    val companyName: String,
    val currentPrice: Double,
    val currentChange: Double,
    val currentChangePercentage: Double,
)

fun GetMarketsResponse.MarketDto.toMarketUi(): MarketUi {
    return MarketUi(
        epic = epic,
        companyName = companyName,
        currentPrice = currentPrice,
        currentChange = currentChange,
        currentChangePercentage = currentChangePercentage
    )
}
