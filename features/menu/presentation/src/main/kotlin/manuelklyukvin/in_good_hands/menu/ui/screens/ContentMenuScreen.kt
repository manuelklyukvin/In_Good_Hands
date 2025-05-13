package manuelklyukvin.in_good_hands.menu.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import manuelklyukvin.in_good_hands.core.ui.components.AppCard
import manuelklyukvin.in_good_hands.core.ui.components.images.AppIcon
import manuelklyukvin.in_good_hands.core.ui.components.images.AppImage
import manuelklyukvin.in_good_hands.core.ui.components.texts.AppLineText
import manuelklyukvin.in_good_hands.core.ui.theme.AppTheme
import manuelklyukvin.in_good_hands.core.ui.theme.LocalNavigationState
import manuelklyukvin.in_good_hands.core.ui.utils.noIndicationClickable
import manuelklyukvin.in_good_hands.menu.R
import manuelklyukvin.in_good_hands.menu.models.PresentationUser
import manuelklyukvin.in_good_hands.menu.ui.view_models.models.MenuIntent
import manuelklyukvin.in_good_hands.menu.ui.view_models.models.MenuState
import manuelklyukvin.in_good_hands.core.R as CoreR

@Composable
internal fun ContentMenuScreen(state: MenuState, onIntent: (MenuIntent) -> Unit) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = AppTheme.shapes.screenPadding)
            .clip(AppTheme.shapes.roundedCornerShape),
        verticalArrangement = Arrangement.spacedBy(AppTheme.shapes.paddingSmall)
    ) {
        item { CurrentUserBlock(state.currentUser, onIntent) }
    }
}

@Composable
private fun CurrentUserBlock(currentUser: PresentationUser?, onIntent: (MenuIntent) -> Unit) {
    val navigationState = LocalNavigationState.current

    AppCard(
        modifier = Modifier
            .fillMaxWidth()
            .noIndicationClickable { onIntent(MenuIntent.OnCurrentUserClicked(navigationState)) },
        areDefaultPaddingsEnabled = true
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            if (currentUser?.avatarUrl != null) {
                AppImage(
                    modifier = Modifier
                        .size(AppTheme.shapes.sizeExtraLarge)
                        .clip(RoundedCornerShape(100)),
                    model = currentUser.avatarUrl,
                    contentScale = ContentScale.Crop
                )
            } else {
                AppIcon(
                    modifier = Modifier.size(AppTheme.shapes.sizeExtraLarge),
                    model = painterResource(CoreR.drawable.avatar)
                )
            }
            Spacer(Modifier.width(AppTheme.shapes.paddingExtraLarge))
            AppLineText(
                text = currentUser?.name ?: stringResource(R.string.guest_name),
                style = AppTheme.typography.headline
            )
        }
    }
}

@Preview
@Composable
private fun LightContentMenuScreenPreview() {
    ContentMenuScreenPreview()
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun DarkContentMenuScreenPreview() {
    ContentMenuScreenPreview()
}

@Composable
private fun ContentMenuScreenPreview() {
    AppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = AppTheme.colorScheme.background
        ) {
            ContentMenuScreen(
                state = MenuState(),
                onIntent = { }
            )
        }
    }
}