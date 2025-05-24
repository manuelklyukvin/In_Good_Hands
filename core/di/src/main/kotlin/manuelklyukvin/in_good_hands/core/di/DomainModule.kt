package manuelklyukvin.in_good_hands.core.di

import manuelklyukvin.in_good_hands.core.operations.use_cases.GetOperationErrorMessageUseCase
import manuelklyukvin.in_good_hands.core.operations.use_cases.GetOperationErrorUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

internal val domainModule = module {
    singleOf(::GetOperationErrorUseCase)
    singleOf(::GetOperationErrorMessageUseCase)
}