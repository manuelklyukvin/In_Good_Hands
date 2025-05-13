package manuelklyukvin.in_good_hands.menu.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import manuelklyukvin.in_good_hands.core.ui.theme.AppTheme

@Composable
internal fun LoadingMenuScreen() {

}

@Preview
@Composable
private fun LightLoadingMenuScreenPreview() {
    LoadingMenuScreenPreview()
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun DarkLoadingMenuScreenPreview() {
    LoadingMenuScreenPreview()
}

@Composable
private fun LoadingMenuScreenPreview() {
    AppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = AppTheme.colorScheme.background
        ) {
            LoadingMenuScreen()
        }
    }
}