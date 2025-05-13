package manuelklyukvin.in_good_hands.menu.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import manuelklyukvin.in_good_hands.core.ui.components.AppCard
import manuelklyukvin.in_good_hands.core.ui.theme.AppTheme
import manuelklyukvin.in_good_hands.core.ui.utils.shimmerEffect

@Composable
internal fun LoadingMenuScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = AppTheme.shapes.screenPadding)
            .clip(AppTheme.shapes.roundedCornerShape),
        verticalArrangement = Arrangement.spacedBy(AppTheme.shapes.paddingSmall)
    ) {
        LoadingCurrentUserBlock()
    }
}

@Composable
private fun LoadingCurrentUserBlock() {
    AppCard(
        modifier = Modifier
            .fillMaxWidth()
            .shimmerEffect(),
        areDefaultPaddingsEnabled = true
    ) {
        Spacer(Modifier.size(AppTheme.shapes.sizeExtraLarge))
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
    AppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = AppTheme.colorScheme.background
        ) {
            LoadingMenuScreen()
        }
    }
}