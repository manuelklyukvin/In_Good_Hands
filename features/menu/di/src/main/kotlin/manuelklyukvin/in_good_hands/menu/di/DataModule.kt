package manuelklyukvin.in_good_hands.menu.di

import manuelklyukvin.in_good_hands.menu.data_sources.UserDataSource
import manuelklyukvin.in_good_hands.menu.repositories.UserRepository
import manuelklyukvin.in_good_hands.menu.repositories.UserRepositoryImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

internal val dataModule = module {
    singleOf(::UserDataSource)
    singleOf(::UserRepositoryImpl) bind UserRepository::class
}