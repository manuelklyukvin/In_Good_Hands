package manuelklyukvin.in_good_hands.core.di

import manuelklyukvin.in_good_hands.core.languages.use_cases.GetLanguageIdUseCase
import manuelklyukvin.in_good_hands.core.posts.use_cases.GetPostImageUrlUseCase
import manuelklyukvin.in_good_hands.core.users.use_cases.GetAvatarUrlUseCase
import manuelklyukvin.in_good_hands.core.utils.operations.use_cases.GetOperationErrorMessageUseCase
import manuelklyukvin.in_good_hands.core.utils.operations.use_cases.GetOperationErrorUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

internal val domainModule = module {
    singleOf(::GetOperationErrorUseCase)
    singleOf(::GetOperationErrorMessageUseCase)

    singleOf(::GetLanguageIdUseCase)

    singleOf(::GetAvatarUrlUseCase)
    singleOf(::GetPostImageUrlUseCase)
}