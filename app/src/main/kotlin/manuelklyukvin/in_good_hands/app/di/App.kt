package manuelklyukvin.in_good_hands.app.di

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import coil.request.CachePolicy
import manuelklyukvin.in_good_hands.addresses.di.addressesModule
import manuelklyukvin.in_good_hands.core.di.coreModule
import manuelklyukvin.in_good_hands.feed.di.feedModule
import manuelklyukvin.in_good_hands.menu.di.menuModule
import manuelklyukvin.in_good_hands.pets.di.petsModule
import manuelklyukvin.in_good_hands.posts.di.postsModule
import manuelklyukvin.in_good_hands.profile.di.profileModule
import manuelklyukvin.in_good_hands.users.di.usersModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application(), ImageLoaderFactory {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                coreModule,
                usersModule, postsModule, petsModule, addressesModule,
                feedModule, menuModule, profileModule
            )
        }
    }

    override fun newImageLoader() = ImageLoader(this)
        .newBuilder()
        .diskCachePolicy(CachePolicy.DISABLED)
        .memoryCachePolicy(CachePolicy.ENABLED)
        .crossfade(true)
        .build()
}