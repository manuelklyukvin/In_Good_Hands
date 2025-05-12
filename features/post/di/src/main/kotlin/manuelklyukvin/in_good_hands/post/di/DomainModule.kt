package manuelklyukvin.in_good_hands.post.di

import manuelklyukvin.in_good_hands.post.use_cases.GetFormatedDateUseCase
import manuelklyukvin.in_good_hands.post.use_cases.GetPostUseCase
import manuelklyukvin.in_good_hands.post.use_cases.OpenMapUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

internal val domainModule = module {
    singleOf(::GetPostUseCase)
    singleOf(::GetFormatedDateUseCase)

    singleOf(::OpenMapUseCase)
}