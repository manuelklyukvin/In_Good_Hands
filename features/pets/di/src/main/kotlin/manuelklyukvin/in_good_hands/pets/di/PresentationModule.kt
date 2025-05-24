package manuelklyukvin.in_good_hands.pets.di

import manuelklyukvin.in_good_hands.pets.mappers.PetGenderMapper
import manuelklyukvin.in_good_hands.pets.mappers.PetMapper
import manuelklyukvin.in_good_hands.pets.mappers.PetTypeMapper
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

internal val presentationModule = module {
    singleOf(::PetMapper)
    singleOf(::PetTypeMapper)
    singleOf(::PetGenderMapper)
}