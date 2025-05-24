package manuelklyukvin.in_good_hands.pets.di

import org.koin.dsl.module

val petsModule = module { includes(dataModule, domainModule, presentationModule) }