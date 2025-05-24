package manuelklyukvin.in_good_hands.profile.di

import manuelklyukvin.in_good_hands.profile.ui.view_models.ProfileViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

internal val presentationModule = module { viewModelOf(::ProfileViewModel) }