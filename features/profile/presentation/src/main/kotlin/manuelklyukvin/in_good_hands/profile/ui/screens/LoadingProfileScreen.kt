package manuelklyukvin.in_good_hands.profile.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import manuelklyukvin.in_good_hands.core.ui.theme.MKUITheme

@Composable
internal fun LoadingProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = MKUITheme.shapes.screenPadding)
            .clip(MKUITheme.shapes.roundedCornerShape),
        verticalArrangement = Arrangement.spacedBy(MKUITheme.shapes.paddingSmall)
    ) {

    }
}

@Preview
@Composable
private fun LightLoadingProfileScreenPreview() {
    LoadingProfileScreenPreview()
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun DarkLoadingProfileScreenPreview() {
    LoadingProfileScreenPreview()
}

@Composable
private fun LoadingProfileScreenPreview() {
    MKUITheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MKUITheme.colorScheme.background
        ) {
            LoadingProfileScreen()
        }
    }
}