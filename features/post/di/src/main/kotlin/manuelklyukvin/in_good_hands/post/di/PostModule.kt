package manuelklyukvin.in_good_hands.post.di

import org.koin.dsl.module

val postModule = module { includes(dataModule, domainModule, presentationModule) }