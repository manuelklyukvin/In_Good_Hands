package manuelklyukvin.in_good_hands.post.di

import manuelklyukvin.in_good_hands.post.mappers.PostMapper
import manuelklyukvin.in_good_hands.post.ui.view_models.PostViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

internal val presentationModule = module {
    singleOf(::PostMapper)
    viewModelOf(::PostViewModel)
}