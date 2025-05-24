package manuelklyukvin.in_good_hands.users.di

import org.koin.dsl.module

val usersModule = module { includes(dataModule, domainModule, presentationModule) }