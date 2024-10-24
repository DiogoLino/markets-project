package com.ajbell.technicaltest

import com.ajbell.technicaltest.market.data.GetMarketsResponse
import com.ajbell.technicaltest.market.domain.MarketsDataSource
import com.ajbell.technicaltest.market.presentation.market_list.MarketListState
import com.ajbell.technicaltest.market.presentation.market_list.MarketListViewModel
import com.ajbell.technicaltest.market.presentation.models.toMarketUi
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test


@ExperimentalCoroutinesApi
class MarketListViewModelTest {

    private val dispatcher = TestCoroutineDispatcher()
    private val marketDataSource = mockk<MarketsDataSource>()
    private var viewModel = MarketListViewModel(
        marketDataSource,
        dispatcher,
    )

    private val collector = ViewModelFlowCollector(viewModel.state, NO_EVENTS, dispatcher)


    @Test
    fun `Test When loading markets THEN correct states are emitted`() =
        collector.test { actualStates, _ ->
            val markets =
                GetMarketsResponse(
                    listOf(
                        GetMarketsResponse.MarketDto(
                            epic = "",
                            companyName = "",
                            currentPrice = 123.23,
                            currentChange = 23423.23,
                            currentChangePercentage = 232.23
                        )
                    )
                )

            val marketsUI = markets.data.map { it.toMarketUi() }

            coEvery { marketDataSource.getMarkets() } returns markets

            viewModel.loadMarkets()


            val expectedState = listOf(
                MarketListState(
                    isLoading = false,
                    markets = emptyList(),
                    selectedMarket = null,
                ),
                MarketListState(
                    isLoading = true,
                    markets = emptyList(),
                    selectedMarket = null,
                ),
                MarketListState(
                    isLoading = false,
                    markets = marketsUI,
                    selectedMarket = null,
                )
            )
            assertEquals(expectedState, actualStates)
        }

    @Test
    fun `Test When User SELECTS market THEN correct states are emitted`() =
        collector.test { actualStates, _ ->
            val markets =
                GetMarketsResponse(
                    listOf(
                        GetMarketsResponse.MarketDto(
                            epic = "",
                            companyName = "",
                            currentPrice = 123.23,
                            currentChange = 23423.23,
                            currentChangePercentage = 232.23
                        )
                    )
                )

            val marketsUI = markets.data.map { it.toMarketUi() }

            coEvery { marketDataSource.getMarkets() } returns markets

            viewModel.loadMarkets()


            val expectedState = listOf(
                MarketListState(
                    isLoading = false,
                    markets = emptyList(),
                    selectedMarket = null,
                ),
                MarketListState(
                    isLoading = true,
                    markets = emptyList(),
                    selectedMarket = null,
                ),
                MarketListState(
                    isLoading = false,
                    markets = marketsUI,
                    selectedMarket = null,
                )
            )
            assertEquals(expectedState, actualStates)
        }
}

