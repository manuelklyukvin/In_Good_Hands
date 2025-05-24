package manuelklyukvin.in_good_hands.core.di

import manuelklyukvin.in_good_hands.core.operations.providers.OperationErrorMessageProvider
import manuelklyukvin.in_good_hands.core.operations.providers.OperationErrorMessageProviderImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

internal val presentationModule = module {
    singleOf(::OperationErrorMessageProviderImpl) bind OperationErrorMessageProvider::class
}