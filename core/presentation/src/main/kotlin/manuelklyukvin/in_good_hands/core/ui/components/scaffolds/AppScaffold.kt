package manuelklyukvin.in_good_hands.core.ui.components.scaffolds

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import manuelklyukvin.in_good_hands.core.ui.theme.AppTheme

@Composable
fun AppScaffold(
    topBar: @Composable () -> Unit = { AppTopBar() },
    bottomBar: @Composable () -> Unit = { AppNavBar() },
    content: @Composable () -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = AppTheme.colorScheme.background,
        topBar = topBar,
        bottomBar = bottomBar
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            content()
        }
    }
}

@Preview
@Composable
private fun LightAppScaffoldPreview() {
    AppScaffoldPreview()
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun DarkAppScaffoldPreview() {
    AppScaffoldPreview()
}

@Composable
private fun AppScaffoldPreview() {
    AppTheme {
        AppScaffold { }
    }
}