package manuelklyukvin.in_good_hands.addresses.di

import org.koin.dsl.module

val addressesModule = module { includes(dataModule, domainModule, presentationModule) }