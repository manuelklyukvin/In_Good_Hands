package manuelklyukvin.in_good_hands.feed.di

import manuelklyukvin.in_good_hands.core.api.Api
import manuelklyukvin.in_good_hands.feed.data_sources.FeedPageDataSource
import manuelklyukvin.in_good_hands.feed.repositories.FeedPageRepository
import manuelklyukvin.in_good_hands.feed.repositories.FeedPageRepositoryImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

internal val dataModule = module {
    single { Api.retrofit.create(FeedPageDataSource::class.java) }
    singleOf(::FeedPageRepositoryImpl) bind FeedPageRepository::class
}