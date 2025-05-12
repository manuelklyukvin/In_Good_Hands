package manuelklyukvin.in_good_hands.core.ui.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import manuelklyukvin.in_good_hands.core.ui.navigation.Routes

fun NavGraphBuilder.profileNavGraph(
    profileScreen: @Composable () -> Unit
) {
    navigation<Routes.ProfileBlock>(startDestination = Routes.Profile) {
        composable<Routes.Profile> { profileScreen() }
    }
}