package manuelklyukvin.in_good_hands.feed.di

import org.koin.dsl.module

val feedModule = module { includes(presentationModule, domainModule, dataModule) }