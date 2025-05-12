package manuelklyukvin.in_good_hands.core.ui.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.toRoute
import manuelklyukvin.in_good_hands.core.ui.navigation.Routes

fun NavGraphBuilder.homeNavGraph(
    feedScreen: @Composable () -> Unit,
    postScreen: @Composable (Long) -> Unit
) {
    navigation<Routes.HomeBlock>(startDestination = Routes.Feed) {
        composable<Routes.Feed> { feedScreen() }
        composable<Routes.Post> { postScreen(it.toRoute<Routes.Post>().postId) }
    }
}