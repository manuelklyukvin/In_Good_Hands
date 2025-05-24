package manuelklyukvin.in_good_hands.users.di

import manuelklyukvin.in_good_hands.users.mappers.UserMapper
import manuelklyukvin.in_good_hands.users.mappers.UserRoleMapper
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

internal val presentationModule = module {
    singleOf(::UserMapper)
    singleOf(::UserRoleMapper)
}