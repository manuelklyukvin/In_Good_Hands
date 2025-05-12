package manuelklyukvin.in_good_hands.app.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import manuelklyukvin.in_good_hands.core.ui.components.scaffolds.AppScaffold
import manuelklyukvin.in_good_hands.core.ui.navigation.graphs.AppNavGraph
import manuelklyukvin.in_good_hands.core.ui.theme.AppTheme
import manuelklyukvin.in_good_hands.feed.ui.screens.FeedScreen
import manuelklyukvin.in_good_hands.post.ui.screens.PostScreen

@Composable
fun AppScreen() {
    AppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = AppTheme.colorScheme.background
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .systemBarsPadding()
            ) {
                AppNavGraph(
                    feedScreen = { FeedScreen() },
                    postScreen = { postId -> PostScreen(postId = postId) },
                    profileScreen = { AppScaffold { } }
                )
            }
        }
    }
}