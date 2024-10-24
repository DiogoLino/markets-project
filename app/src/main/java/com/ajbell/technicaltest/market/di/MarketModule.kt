package com.ajbell.technicaltest.market.di

import com.ajbell.technicaltest.market.data.MarketRepository
import com.ajbell.technicaltest.market.domain.MarketsDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped


@Module
@InstallIn(ViewModelComponent::class)
internal abstract class MarketModule {

    @ViewModelScoped
    @Binds
    abstract fun bindMarketDataSource(repositoryImpl: MarketRepository): MarketsDataSource

}