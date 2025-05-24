package manuelklyukvin.in_good_hands.addresses.di

import manuelklyukvin.in_good_hands.addresses.use_cases.GetLanguageIdUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

internal val domainModule = module { singleOf(::GetLanguageIdUseCase) }