package manuelklyukvin.in_good_hands.post.di

import manuelklyukvin.in_good_hands.core.api.Api
import manuelklyukvin.in_good_hands.post.adapters.MapAdapter
import manuelklyukvin.in_good_hands.post.adapters.MapAdapterImpl
import manuelklyukvin.in_good_hands.post.data_sources.PostDataSource
import manuelklyukvin.in_good_hands.post.repositories.PostRepository
import manuelklyukvin.in_good_hands.post.repositories.PostRepositoryImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

internal val dataModule = module {
    single { Api.retrofit.create(PostDataSource::class.java) }
    singleOf(::PostRepositoryImpl) bind PostRepository::class

    singleOf(::MapAdapterImpl) bind MapAdapter::class
}