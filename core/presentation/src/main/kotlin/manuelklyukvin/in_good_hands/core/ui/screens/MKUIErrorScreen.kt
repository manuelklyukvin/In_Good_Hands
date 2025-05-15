package manuelklyukvin.in_good_hands.core.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import manuelklyukvin.in_good_hands.core.R
import manuelklyukvin.in_good_hands.core.ui.components.buttons.MKUIButton
import manuelklyukvin.in_good_hands.core.ui.components.texts.MKUIText
import manuelklyukvin.in_good_hands.core.ui.theme.MKUITheme

@Composable
fun MKUIErrorScreen(error: String?, onRetryButtonClicked: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MKUITheme.colorScheme.background)
            .padding(MKUITheme.shapes.paddingExtraLarge),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MKUIText(
            text = error ?: stringResource(R.string.operation_error_unknown),
            style = MKUITheme.typography.title,
            color = MKUITheme.colorScheme.error,
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(MKUITheme.shapes.paddingExtraSmall))
        MKUIButton(
            text = stringResource(R.string.retry_button),
            onClick = onRetryButtonClicked
        )
    }
}

@Preview
@Composable
private fun LightMKUIErrorScreenPreview() {
    MKUIErrorScreenPreview()
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun DarkMKUIErrorScreenPreview() {
    MKUIErrorScreenPreview()
}

@Composable
private fun MKUIErrorScreenPreview() {
    MKUITheme {
        MKUIErrorScreen(
            error = null,
            onRetryButtonClicked = { }
        )
    }
}