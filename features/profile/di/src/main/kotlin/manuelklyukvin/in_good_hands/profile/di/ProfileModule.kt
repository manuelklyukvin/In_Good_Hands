package manuelklyukvin.in_good_hands.profile.di

import org.koin.dsl.module

val profileModule = module { includes(dataModule, domainModule, presentationModule) }