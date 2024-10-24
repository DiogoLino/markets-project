package com.ajbell.technicaltest.market.presentation.market_list

import androidx.compose.runtime.Immutable
import com.ajbell.technicaltest.market.presentation.models.MarketUi

@Immutable
data class MarketListState(
    val isLoading: Boolean = false,
    val markets: List<MarketUi> = emptyList(),
    val selectedMarket: MarketUi? = null
)