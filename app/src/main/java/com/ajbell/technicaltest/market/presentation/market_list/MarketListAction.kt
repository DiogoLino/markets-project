package com.ajbell.technicaltest.market.presentation.market_list

import com.ajbell.technicaltest.market.presentation.models.MarketUi


sealed interface MarketListAction {
    data class OnMarketClick(val marketUi: MarketUi): MarketListAction
}