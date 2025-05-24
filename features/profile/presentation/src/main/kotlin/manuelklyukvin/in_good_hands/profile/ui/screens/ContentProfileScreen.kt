package manuelklyukvin.in_good_hands.profile.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import manuelklyukvin.in_good_hands.core.ui.theme.MKUITheme
import manuelklyukvin.in_good_hands.profile.ui.view_models.models.ProfileIntent
import manuelklyukvin.in_good_hands.profile.ui.view_models.models.ProfileState

@Composable
internal fun ContentProfileScreen(state: ProfileState, onIntent: (ProfileIntent) -> Unit) {
    state.user ?: return

    LazyColumn(
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
private fun LightContentProfileScreenPreview() {
    ContentProfileScreenPreview()
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun DarkContentProfileScreenPreview() {
    ContentProfileScreenPreview()
}

@Composable
private fun ContentProfileScreenPreview() {
    MKUITheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MKUITheme.colorScheme.background
        ) {
            ContentProfileScreen(
                state = ProfileState(),
                onIntent = { }
            )
        }
    }
}