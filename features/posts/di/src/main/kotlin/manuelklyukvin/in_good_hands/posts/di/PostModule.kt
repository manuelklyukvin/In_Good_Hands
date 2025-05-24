package manuelklyukvin.in_good_hands.posts.di

import org.koin.dsl.module

val postsModule = module { includes(dataModule, domainModule, presentationModule) }