package manuelklyukvin.in_good_hands.app.di

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import coil.request.CachePolicy
import manuelklyukvin.in_good_hands.core.di.coreModule
import manuelklyukvin.in_good_hands.feed.di.feedModule
import manuelklyukvin.in_good_hands.post.di.postModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application(), ImageLoaderFactory {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                coreModule,
                feedModule, postModule
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