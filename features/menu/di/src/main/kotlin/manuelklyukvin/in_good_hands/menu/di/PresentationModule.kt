package manuelklyukvin.in_good_hands.menu.di

import manuelklyukvin.in_good_hands.menu.mappers.UserMapper
import manuelklyukvin.in_good_hands.menu.ui.view_models.MenuViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

internal val presentationModule = module {
    singleOf(::UserMapper)
    viewModelOf(::MenuViewModel)
}