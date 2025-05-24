package manuelklyukvin.in_good_hands.posts.di

import manuelklyukvin.in_good_hands.core.api.Api
import manuelklyukvin.in_good_hands.posts.adapters.MapAdapter
import manuelklyukvin.in_good_hands.posts.adapters.MapAdapterImpl
import manuelklyukvin.in_good_hands.posts.data_sources.PostDataSource
import manuelklyukvin.in_good_hands.posts.providers.PostImageUrlProvider
import manuelklyukvin.in_good_hands.posts.providers.PostImageUrlProviderImpl
import manuelklyukvin.in_good_hands.posts.repositories.PostRepository
import manuelklyukvin.in_good_hands.posts.repositories.PostRepositoryImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

internal val dataModule = module {
    single { Api.retrofit.create(PostDataSource::class.java) }
    singleOf(::PostRepositoryImpl) bind PostRepository::class

    singleOf(::PostImageUrlProviderImpl) bind PostImageUrlProvider::class
    singleOf(::MapAdapterImpl) bind MapAdapter::class
}