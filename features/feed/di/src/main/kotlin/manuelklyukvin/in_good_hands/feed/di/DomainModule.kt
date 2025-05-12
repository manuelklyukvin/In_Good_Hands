package manuelklyukvin.in_good_hands.feed.di

import manuelklyukvin.in_good_hands.feed.use_cases.GetFeedPageUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

internal val domainModule = module { singleOf(::GetFeedPageUseCase) }