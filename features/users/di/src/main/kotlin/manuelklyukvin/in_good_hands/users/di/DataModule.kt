package manuelklyukvin.in_good_hands.users.di

import manuelklyukvin.in_good_hands.users.data_sources.UserDataSource
import manuelklyukvin.in_good_hands.users.providers.AvatarUrlProvider
import manuelklyukvin.in_good_hands.users.providers.AvatarUrlProviderImpl
import manuelklyukvin.in_good_hands.users.repositories.UserRepository
import manuelklyukvin.in_good_hands.users.repositories.UserRepositoryImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

internal val dataModule = module {
    singleOf(::UserDataSource)
    singleOf(::UserRepositoryImpl) bind UserRepository::class

    singleOf(::AvatarUrlProviderImpl) bind AvatarUrlProvider::class
}