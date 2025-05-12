package manuelklyukvin.in_good_hands.feed.di

import manuelklyukvin.in_good_hands.feed.mappers.FeedPostMapper
import manuelklyukvin.in_good_hands.feed.ui.utils.FeedGridCalculator
import manuelklyukvin.in_good_hands.feed.ui.view_models.FeedViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

internal val presentationModule = module {
    singleOf(::FeedPostMapper)
    singleOf(::FeedGridCalculator)
    viewModelOf(::FeedViewModel)
}