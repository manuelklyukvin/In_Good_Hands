package manuelklyukvin.in_good_hands.menu.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import manuelklyukvin.in_good_hands.core.ui.components.MKUILoadingItem
import manuelklyukvin.in_good_hands.core.ui.theme.MKUITheme

@Composable
internal fun LoadingMenuScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = MKUITheme.shapes.screenPadding)
            .clip(MKUITheme.shapes.roundedCornerShape),
        verticalArrangement = Arrangement.spacedBy(MKUITheme.shapes.paddingSmall)
    ) {
        repeat(2) {
            MKUILoadingItem(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
            )
        }
    }
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
    MKUITheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MKUITheme.colorScheme.background
        ) {
            LoadingMenuScreen()
        }
    }
}