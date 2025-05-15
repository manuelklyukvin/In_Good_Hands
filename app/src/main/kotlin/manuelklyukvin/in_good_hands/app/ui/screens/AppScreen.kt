package manuelklyukvin.in_good_hands.app.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import manuelklyukvin.in_good_hands.core.ui.components.scaffolds.MKUIScaffold
import manuelklyukvin.in_good_hands.core.ui.navigation.graphs.AppNavGraph
import manuelklyukvin.in_good_hands.core.ui.theme.MKUITheme
import manuelklyukvin.in_good_hands.feed.ui.screens.FeedScreen
import manuelklyukvin.in_good_hands.menu.ui.screens.MenuScreen
import manuelklyukvin.in_good_hands.post.ui.screens.PostScreen

@Composable
fun AppScreen() {
    MKUITheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MKUITheme.colorScheme.background
        ) {
            MKUIScaffold {
                AppNavGraph(
                    feedScreen = { FeedScreen() },
                    postScreen = { postId -> PostScreen(postId = postId) },
                    menuScreen = { MenuScreen() }
                )
            }
        }
    }
}