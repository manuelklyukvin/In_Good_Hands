package manuelklyukvin.in_good_hands.core.di

import org.koin.dsl.module

val coreModule = module { includes(dataModule, domainModule, presentationModule) }