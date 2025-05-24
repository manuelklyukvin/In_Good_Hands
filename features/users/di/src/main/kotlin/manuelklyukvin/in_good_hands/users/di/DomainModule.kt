package manuelklyukvin.in_good_hands.users.di

import manuelklyukvin.in_good_hands.users.use_cases.GetAvatarUrlUseCase
import manuelklyukvin.in_good_hands.users.use_cases.GetCurrentUserUseCase
import manuelklyukvin.in_good_hands.users.use_cases.GetUserUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

internal val domainModule = module {
    singleOf(::GetUserUseCase)
    singleOf(::GetCurrentUserUseCase)

    singleOf(::GetAvatarUrlUseCase)
}