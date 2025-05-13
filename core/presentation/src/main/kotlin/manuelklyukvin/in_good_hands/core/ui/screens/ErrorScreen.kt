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
import manuelklyukvin.in_good_hands.core.ui.components.AppButton
import manuelklyukvin.in_good_hands.core.ui.components.texts.AppText
import manuelklyukvin.in_good_hands.core.ui.theme.AppTheme

@Composable
fun ErrorScreen(error: String?, onRetryButtonClicked: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppTheme.colorScheme.background)
            .padding(AppTheme.shapes.paddingExtraLarge),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AppText(
            text = error ?: stringResource(R.string.operation_error_unknown),
            style = AppTheme.typography.title,
            color = AppTheme.colorScheme.error,
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(AppTheme.shapes.paddingExtraSmall))
        AppButton(
            text = stringResource(R.string.retry_button),
            onClick = onRetryButtonClicked
        )
    }
}

@Preview
@Composable
private fun LightErrorScreenPreview() {
    ErrorScreenPreview()
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun DarkErrorScreenPreview() {
    ErrorScreenPreview()
}

@Composable
private fun ErrorScreenPreview() {
    AppTheme {
        ErrorScreen(
            error = null,
            onRetryButtonClicked = { }
        )
    }
}