package manuelklyukvin.in_good_hands.menu.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import manuelklyukvin.in_good_hands.core.ui.components.MKUICard
import manuelklyukvin.in_good_hands.core.ui.components.buttons.MKUIButton
import manuelklyukvin.in_good_hands.core.ui.components.buttons.MKUIButtons
import manuelklyukvin.in_good_hands.core.ui.components.images.MKUIIcon
import manuelklyukvin.in_good_hands.core.ui.components.images.MKUIImage
import manuelklyukvin.in_good_hands.core.ui.components.texts.MKUILineText
import manuelklyukvin.in_good_hands.core.ui.theme.LocalNavigationState
import manuelklyukvin.in_good_hands.core.ui.theme.MKUITheme
import manuelklyukvin.in_good_hands.core.ui.utils.noIndicationClickable
import manuelklyukvin.in_good_hands.menu.R
import manuelklyukvin.in_good_hands.menu.ui.view_models.models.MenuIntent
import manuelklyukvin.in_good_hands.menu.ui.view_models.models.MenuState
import manuelklyukvin.in_good_hands.users.models.PresentationUser
import manuelklyukvin.in_good_hands.core.R as CoreR

@Composable
internal fun ContentMenuScreen(state: MenuState, onIntent: (MenuIntent) -> Unit) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = MKUITheme.shapes.screenPadding)
            .clip(MKUITheme.shapes.roundedCornerShape),
        verticalArrangement = Arrangement.spacedBy(MKUITheme.shapes.paddingSmall)
    ) {
        item { CurrentUserBlock(state.currentUser, onIntent) }
        if (state.currentUser == null) {
            item { SignInButtons(onIntent) }
        } else {
            item { PublishPostButton(onIntent) }
            item { SignOutButton(onIntent) }
        }
    }
}

@Composable
private fun CurrentUserBlock(currentUser: PresentationUser?, onIntent: (MenuIntent) -> Unit) {
    val navigationState = LocalNavigationState.current

    MKUICard(
        modifier = Modifier
            .fillMaxWidth()
            .noIndicationClickable { onIntent(MenuIntent.OnCurrentUserClicked(navigationState)) },
        areDefaultPaddingsEnabled = true
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            if (currentUser?.avatarUrl != null) {
                MKUIImage(
                    modifier = Modifier
                        .size(MKUITheme.shapes.sizeExtraLarge)
                        .clip(RoundedCornerShape(100)),
                    model = currentUser.avatarUrl!!,
                    contentScale = ContentScale.Crop
                )
            } else {
                MKUIIcon(
                    modifier = Modifier.size(MKUITheme.shapes.sizeExtraLarge),
                    model = painterResource(CoreR.drawable.avatar)
                )
            }
            Spacer(Modifier.width(MKUITheme.shapes.paddingExtraLarge))
            Column {
                MKUILineText(
                    text = currentUser?.name ?: stringResource(R.string.guest_name),
                    style = MKUITheme.typography.headline
                )
                currentUser?.let {
                    MKUILineText(
                        text = stringResource(currentUser.roleResId),
                        style = MKUITheme.typography.body,
                        color = MKUITheme.colorScheme.primary
                    )
                }
            }
        }
    }
}

@Composable
private fun SignInButtons(onIntent: (MenuIntent) -> Unit) {
    val navigationState = LocalNavigationState.current

    val signInButton = stringResource(R.string.sign_in_button) to {
        onIntent(MenuIntent.OnSignInButtonClicked(navigationState))
    }
    val signUpButton = stringResource(R.string.sign_up_button) to {
        onIntent(MenuIntent.OnSignUpButtonClicked(navigationState))
    }
    MKUIButtons(buttons = arrayOf(signInButton, signUpButton))
}

@Composable
private fun SignOutButton(onIntent: (MenuIntent) -> Unit) {
    MKUICard(
        modifier = Modifier
            .fillMaxWidth()
            .noIndicationClickable { onIntent(MenuIntent.OnSignOutButtonClicked) },
        areDefaultPaddingsEnabled = true,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MKUILineText(
            text = stringResource(R.string.sign_out_button),
            color = MKUITheme.colorScheme.error
        )
    }
}

@Composable
private fun PublishPostButton(onIntent: (MenuIntent) -> Unit) {
    val navigationState = LocalNavigationState.current

    MKUIButton(
        modifier = Modifier.fillMaxWidth(),
        text = stringResource(R.string.publish_post_button),
        onClick = { onIntent(MenuIntent.OnPublishPostButtonClicked(navigationState)) }
    )
}

@Preview
@Composable
private fun LightGuestContentMenuScreenPreview() {
    ContentGuestMenuScreenPreview()
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun DarkGuestContentMenuScreenPreview() {
    ContentGuestMenuScreenPreview()
}

@Preview
@Composable
private fun LightUserContentMenuScreenPreview() {
    ContentUserMenuScreenPreview()
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun DarkUserContentMenuScreenPreview() {
    ContentUserMenuScreenPreview()
}

@Composable
private fun ContentGuestMenuScreenPreview() {
    MKUITheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MKUITheme.colorScheme.background
        ) {
            ContentMenuScreen(
                state = MenuState(),
                onIntent = { }
            )
        }
    }
}

@Composable
private fun ContentUserMenuScreenPreview() {
    MKUITheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MKUITheme.colorScheme.background
        ) {
            ContentMenuScreen(
                state = MenuState(
                    currentUser = PresentationUser(
                        id = 0,
                        roleResId = R.string.guest_name,
                        avatarUrl = null,
                        name = "User",
                        email = "user@mail.com",
                        phoneNumber = "+1 (000) 000-00-00"
                    )
                ),
                onIntent = { }
            )
        }
    }
}