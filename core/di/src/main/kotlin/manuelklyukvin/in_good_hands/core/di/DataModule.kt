package manuelklyukvin.in_good_hands.core.di

import manuelklyukvin.in_good_hands.core.posts.providers.PostImageUrlProvider
import manuelklyukvin.in_good_hands.core.posts.providers.PostImageUrlProviderImpl
import manuelklyukvin.in_good_hands.core.users.providers.AvatarUrlProvider
import manuelklyukvin.in_good_hands.core.users.providers.AvatarUrlProviderImpl
import manuelklyukvin.in_good_hands.core.utils.operations.providers.OperationErrorProvider
import manuelklyukvin.in_good_hands.core.utils.operations.providers.OperationErrorProviderImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

internal val dataModule = module {
    singleOf(::OperationErrorProviderImpl) bind OperationErrorProvider::class

    singleOf(::AvatarUrlProviderImpl) bind AvatarUrlProvider::class
    singleOf(::PostImageUrlProviderImpl) bind PostImageUrlProvider::class
}