package manuelklyukvin.in_good_hands.menu.di

import manuelklyukvin.in_good_hands.menu.use_cases.GetCurrentUserUseCase
import manuelklyukvin.in_good_hands.menu.use_cases.SignOutUserUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

internal val domainModule = module {
    singleOf(::GetCurrentUserUseCase)
    singleOf(::SignOutUserUseCase)
}