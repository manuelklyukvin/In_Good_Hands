package manuelklyukvin.in_good_hands.posts.di

import manuelklyukvin.in_good_hands.posts.use_cases.GetFormatedDateUseCase
import manuelklyukvin.in_good_hands.posts.use_cases.GetPostImageUrlUseCase
import manuelklyukvin.in_good_hands.posts.use_cases.GetPostUseCase
import manuelklyukvin.in_good_hands.posts.use_cases.OpenMapUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

internal val domainModule = module {
    singleOf(::GetPostUseCase)
    singleOf(::GetFormatedDateUseCase)

    singleOf(::GetPostImageUrlUseCase)
    singleOf(::OpenMapUseCase)
}