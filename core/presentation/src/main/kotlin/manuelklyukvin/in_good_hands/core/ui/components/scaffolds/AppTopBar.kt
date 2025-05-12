package manuelklyukvin.in_good_hands.core.ui.components.scaffolds

import android.content.res.Configuration
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import manuelklyukvin.in_good_hands.core.R
import manuelklyukvin.in_good_hands.core.ui.components.images.AppIcon
import manuelklyukvin.in_good_hands.core.ui.theme.AppTheme
import manuelklyukvin.in_good_hands.core.ui.theme.LocalNavigationState
import manuelklyukvin.in_good_hands.core.ui.utils.noIndicationClickable

@Composable
fun AppTopBar() {
    val navigationState = LocalNavigationState.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                vertical = AppTheme.shapes.paddingSmall,
                horizontal = AppTheme.shapes.screenPadding
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AppIcon(
            modifier = Modifier
                .size(AppTheme.shapes.sizeMedium)
                .noIndicationClickable { navigationState.navigateUp() },
            model = painterResource(R.drawable.arrow_back)
        )
    }
}

@Preview
@Composable
private fun LightAppTopBarPreview() {
    AppTopBarPreview()
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun DarkAppTopBarPreview() {
    AppTopBarPreview()
}

@Composable
private fun AppTopBarPreview() {
    AppTheme {
        Surface(color = AppTheme.colorScheme.background) {
            AppTopBar()
        }
    }
}