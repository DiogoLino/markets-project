package com.ajbell.technicaltest.market.presentation.market_list


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.ajbell.technicaltest.market.presentation.market_list.components.MarketListItem
import com.ajbell.technicaltest.market.presentation.market_list.components.previewMarket
import com.ajbell.technicaltest.theme.AjBellTestAppTheme


@Composable
fun MarketListScreen(
    state: MarketListState,
    onAction: (MarketListAction) -> Unit,
    modifier: Modifier = Modifier
) {
    if(state.isLoading) {
        Box(
            modifier = modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        LazyColumn(
            modifier = modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(state.markets) { marketUi ->
                MarketListItem(
                    marketUi = marketUi,
                    onClick = {
                        onAction(MarketListAction.OnMarketClick(marketUi))
                    },
                    modifier = Modifier.fillMaxWidth()
                )
                HorizontalDivider()
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun MarketListScreenPreview() {
    AjBellTestAppTheme {
        MarketListScreen(
            state = MarketListState(
                markets = (1..100).map {
                    previewMarket.copy(companyName = it.toString())
                }
            ),
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background),
            onAction = {}
        )
    }
}