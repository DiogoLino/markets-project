package com.ajbell.technicaltest.market.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class GetMarketsResponse(
    @SerializedName("data")
    val data: List<MarketDto>
) {
    @Parcelize
    data class MarketDto(
        @SerializedName("Epic")
        val epic: String,
        @SerializedName("CompanyName")
        val companyName: String,
        @SerializedName("CurrentPrice")
        val currentPrice: Double,
        @SerializedName("CurrentChange")
        val currentChange: Double,
        @SerializedName("CurrentChangePct")
        val currentChangePercentage: Double
    ) : Parcelable
}
