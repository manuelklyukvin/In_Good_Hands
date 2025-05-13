package manuelklyukvin.in_good_hands.core.ui.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import manuelklyukvin.in_good_hands.core.ui.navigation.Routes
import manuelklyukvin.in_good_hands.core.ui.theme.LocalNavigationState
import manuelklyukvin.in_good_hands.core.ui.theme.resources.Animations

@Composable
fun AppNavGraph(
    feedScreen: @Composable () -> Unit,
    postScreen: @Composable (Long) -> Unit,
    menuScreen: @Composable () -> Unit
) {
    NavHost(
        navController = LocalNavigationState.current.navController,
        startDestination = Routes.HomeBlock,
        enterTransition = Animations.enterTransition,
        popExitTransition = Animations.exitTransition
    ) {
        homeNavGraph(
            feedScreen = { feedScreen() },
            postScreen = { postId -> postScreen(postId) }
        )
        menuNavGraph(
            menuScreen = { menuScreen() }
        )
    }
}