package com.ajbell.technicaltest.market.presentation.market_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ajbell.technicaltest.core.IoDispatcher
import com.ajbell.technicaltest.market.domain.MarketsDataSource
import com.ajbell.technicaltest.market.presentation.models.toMarketUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MarketListViewModel @Inject constructor(
    private val marketsDataSource: MarketsDataSource,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _state = MutableStateFlow(MarketListState())
    val state: Flow<MarketListState> = _state

    fun loadMarkets() = viewModelScope.launch(dispatcher) {
        _state.update {
            it.copy(
                isLoading = true
            )
        }

        val markets = marketsDataSource.getMarkets().data.map { it.toMarketUi() }
        _state.update { it.copy(isLoading = false, markets = markets) }
    }

    fun onItemClicked(action: MarketListAction) {
        when (action) {
            is MarketListAction.OnMarketClick -> {
                _state.update { it.copy(selectedMarket = action.marketUi) }
            }
        }
    }
}