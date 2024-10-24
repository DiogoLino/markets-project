@file:OptIn(ExperimentalMaterial3AdaptiveApi::class)

package com.ajbell.technicaltest.core.navigation

import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.layout.AnimatedPane
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffoldRole
import androidx.compose.material3.adaptive.navigation.NavigableListDetailPaneScaffold
import androidx.compose.material3.adaptive.navigation.rememberListDetailPaneScaffoldNavigator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ajbell.technicaltest.market.presentation.market_detail.MarketDetailScreen
import com.ajbell.technicaltest.market.presentation.market_list.MarketListAction
import com.ajbell.technicaltest.market.presentation.market_list.MarketListScreen
import com.ajbell.technicaltest.market.presentation.market_list.MarketListState
import com.ajbell.technicaltest.market.presentation.market_list.MarketListViewModel

@Composable
fun AdaptiveMarketListDetailPane(
    modifier: Modifier = Modifier,
    viewModel: MarketListViewModel = viewModel()
) {
    LaunchedEffect(Unit) {
        viewModel.loadMarkets()
    }
    val state by viewModel.state.collectAsStateWithLifecycle(MarketListState())

    val navigator = rememberListDetailPaneScaffoldNavigator<Any>()
    NavigableListDetailPaneScaffold(
        navigator = navigator,
        listPane = {
            AnimatedPane {
                MarketListScreen(
                    state = state,
                    onAction = { action ->
                        viewModel.onItemClicked(action)
                        when (action) {
                            is MarketListAction.OnMarketClick -> {
                                navigator.navigateTo(
                                    pane = ListDetailPaneScaffoldRole.Detail,
                                )
                            }
                        }
                    }
                )
            }
        },
        detailPane = {
            AnimatedPane {
                MarketDetailScreen(state = state)
            }
        },
        modifier = modifier
    )
}