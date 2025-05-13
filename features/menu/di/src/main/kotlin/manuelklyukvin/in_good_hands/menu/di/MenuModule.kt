package manuelklyukvin.in_good_hands.menu.di

import org.koin.dsl.module

val menuModule = module { includes(dataModule, domainModule, presentationModule) }