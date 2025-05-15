package manuelklyukvin.in_good_hands.core.ui.components.scaffolds

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import manuelklyukvin.in_good_hands.core.ui.theme.MKUITheme

@Composable
fun MKUIScaffold(content: @Composable () -> Unit) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding(),
        containerColor = Color.Transparent,
        bottomBar = { MKUINavBar() }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            content()
        }
    }
}

@Preview
@Composable
private fun LightMKUIScaffoldPreview() {
    MKUIScaffoldPreview()
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun DarkMKUIScaffoldPreview() {
    MKUIScaffoldPreview()
}

@Composable
private fun MKUIScaffoldPreview() {
    MKUITheme {
        Surface(color = MKUITheme.colorScheme.background) {
            MKUIScaffold { }
        }
    }
}