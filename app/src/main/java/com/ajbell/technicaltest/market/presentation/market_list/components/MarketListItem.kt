package com.ajbell.technicaltest.market.presentation.market_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ajbell.technicaltest.market.data.GetMarketsResponse
import com.ajbell.technicaltest.market.presentation.models.MarketUi
import com.ajbell.technicaltest.market.presentation.models.toMarketUi
import com.ajbell.technicaltest.theme.AjBellTestAppTheme

@Composable
fun MarketListItem(
    marketUi: MarketUi,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val contentColor = if (isSystemInDarkTheme()) {
        Color.White
    } else {
        Color.Black
    }
    Row(
        modifier = modifier
            .clickable(onClick = onClick)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = marketUi.companyName,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = contentColor
        )
    }
}

@PreviewLightDark
@Composable
private fun MarketListItemPreview() {
    AjBellTestAppTheme  {
        MarketListItem(
            marketUi = previewMarket,
            onClick = { /*TODO*/ },
            modifier = Modifier.background(
                MaterialTheme.colorScheme.background
            )
        )
    }
}

internal val previewMarket = GetMarketsResponse.MarketDto(
    epic = "Epic",
    companyName = "Aj Bell",
    currentPrice = 12323.23,
    currentChange = 3424.234,
    currentChangePercentage = 234234.23423,
).toMarketUi()
