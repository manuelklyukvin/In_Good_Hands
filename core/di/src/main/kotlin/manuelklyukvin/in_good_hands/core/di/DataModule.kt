package manuelklyukvin.in_good_hands.core.di

import manuelklyukvin.in_good_hands.core.operations.providers.OperationErrorProvider
import manuelklyukvin.in_good_hands.core.operations.providers.OperationErrorProviderImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

internal val dataModule = module {
    singleOf(::OperationErrorProviderImpl) bind OperationErrorProvider::class
}