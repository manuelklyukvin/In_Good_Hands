package manuelklyukvin.in_good_hands.core.di

import manuelklyukvin.in_good_hands.core.pets.mappers.PetAgeMapper
import manuelklyukvin.in_good_hands.core.pets.mappers.PetGenderMapper
import manuelklyukvin.in_good_hands.core.pets.mappers.PetTypeMapper
import manuelklyukvin.in_good_hands.core.utils.operations.providers.OperationErrorMessageProvider
import manuelklyukvin.in_good_hands.core.utils.operations.providers.OperationErrorMessageProviderImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

internal val presentationModule = module {
    singleOf(::OperationErrorMessageProviderImpl) bind OperationErrorMessageProvider::class

    singleOf(::PetTypeMapper)
    singleOf(::PetGenderMapper)
    singleOf(::PetAgeMapper)
}