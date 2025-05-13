package manuelklyukvin.in_good_hands.menu.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import manuelklyukvin.in_good_hands.core.ui.theme.AppTheme
import manuelklyukvin.in_good_hands.menu.ui.view_models.models.MenuIntent
import manuelklyukvin.in_good_hands.menu.ui.view_models.models.MenuState

@Composable
internal fun ContentMenuScreen(state: MenuState, onIntent: (MenuIntent) -> Unit) {

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