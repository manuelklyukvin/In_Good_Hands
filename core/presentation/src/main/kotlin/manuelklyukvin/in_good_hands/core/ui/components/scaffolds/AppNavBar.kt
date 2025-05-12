package manuelklyukvin.in_good_hands.core.ui.components.scaffolds

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import manuelklyukvin.in_good_hands.core.R
import manuelklyukvin.in_good_hands.core.ui.components.images.AppIcon
import manuelklyukvin.in_good_hands.core.ui.components.texts.AppLineText
import manuelklyukvin.in_good_hands.core.ui.navigation.Routes
import manuelklyukvin.in_good_hands.core.ui.theme.AppTheme
import manuelklyukvin.in_good_hands.core.ui.theme.LocalNavigationState
import manuelklyukvin.in_good_hands.core.ui.utils.noIndicationClickable

@Composable
fun AppNavBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(AppTheme.colorScheme.background)
            .padding(AppTheme.shapes.screenPadding),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        AppNavBarItem(
            icon = painterResource(R.drawable.home),
            label = stringResource(R.string.home_nav_bar_button),
            block = Routes.HomeBlock,
            startRoute = Routes.Feed
        )
        AppNavBarItem(
            icon = painterResource(R.drawable.profile),
            label = stringResource(R.string.profile_nav_bar_button),
            block = Routes.ProfileBlock,
            startRoute = Routes.Profile
        )
    }
}

@Composable
private fun AppNavBarItem(
    icon: Painter,
    label: String,
    block: Routes,
    startRoute: Routes
) {
    val navigationState = LocalNavigationState.current
    val navBackStackEntry by navigationState.navController.currentBackStackEntryAsState()

    val currentRoute = navBackStackEntry?.destination?.route
    val isSelected = navBackStackEntry?.destination?.hierarchy?.any {
        it.route?.contains(block.toString()) == true
    } ?: false

    val currentColor = if (isSelected) {
        AppTheme.colorScheme.primary
    } else {
        AppTheme.colorScheme.onBackground
    }

    Column(
        modifier = Modifier.noIndicationClickable {
            if (currentRoute?.contains(startRoute.toString()) == false) {
                navigationState.navigateToBlock(block)
            }
        },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AppIcon(
            modifier = Modifier.size(AppTheme.shapes.sizeSmall),
            model = icon,
            tint = currentColor
        )
        Spacer(Modifier.height(AppTheme.shapes.paddingExtraSmall))
        AppLineText(
            text = label,
            color = currentColor
        )
    }
}

@Preview
@Composable
private fun LightAppNavBarPreview() {
    AppNavBarPreview()
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun DarkAppNavBarPreview() {
    AppNavBarPreview()
}

@Composable
private fun AppNavBarPreview() {
    AppTheme {
        AppNavBar()
    }
}