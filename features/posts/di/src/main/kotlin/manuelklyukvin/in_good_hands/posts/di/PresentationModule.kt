package manuelklyukvin.in_good_hands.posts.di

import manuelklyukvin.in_good_hands.posts.mappers.PostMapper
import manuelklyukvin.in_good_hands.posts.ui.view_models.PostViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

internal val presentationModule = module {
    singleOf(::PostMapper)
    viewModelOf(::PostViewModel)
}