package manuelklyukvin.in_good_hands.core.ui.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import manuelklyukvin.in_good_hands.core.ui.navigation.Routes

fun NavGraphBuilder.menuNavGraph(
    menuScreen: @Composable () -> Unit
) {
    navigation<Routes.MenuBlock>(startDestination = Routes.Menu) {
        composable<Routes.Menu> { menuScreen() }
    }
}