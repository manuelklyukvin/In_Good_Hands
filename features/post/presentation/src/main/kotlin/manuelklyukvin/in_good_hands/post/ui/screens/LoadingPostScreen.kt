package manuelklyukvin.in_good_hands.post.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import manuelklyukvin.in_good_hands.core.ui.components.AppCard
import manuelklyukvin.in_good_hands.core.ui.components.AppLoadingItem
import manuelklyukvin.in_good_hands.core.ui.theme.AppTheme
import manuelklyukvin.in_good_hands.post.ui.utils.PostScreenParams

@Composable
internal fun LoadingPostScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = AppTheme.shapes.screenPadding)
            .clip(AppTheme.shapes.roundedCornerShape),
        verticalArrangement = Arrangement.spacedBy(AppTheme.shapes.paddingSmall)
    ) {
        LoadingImagePager()
        LoadingPostInfo()
        LoadingUserInfo()
    }
}

@Composable
private fun LoadingImagePager() {
    AppLoadingItem(
        modifier = Modifier
            .fillMaxWidth()
            .height(PostScreenParams.IMAGE_HEIGHT)
    )
}

@Composable
private fun LoadingPostInfo() {
    AppCard(
        modifier = Modifier.fillMaxWidth(),
        areDefaultPaddingsEnabled = true
    ) {
        LoadingTitle()
        Spacer(Modifier.height(AppTheme.shapes.paddingSmall))
        LoadingPetInfo()
    }
}

@Composable
private fun LoadingTitle() {
    Column(verticalArrangement = Arrangement.spacedBy(AppTheme.shapes.paddingExtraSmall)) {
        AppLoadingItem(
            modifier = Modifier
                .fillMaxWidth()
                .height(AppTheme.shapes.textHeadlineHeight)
        )
        repeat(3) {
            AppLoadingItem(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(AppTheme.shapes.textBodyHeight)
            )
        }
    }
}

@Composable
private fun LoadingPetInfo() {
    Column(verticalArrangement = Arrangement.spacedBy(AppTheme.shapes.paddingExtraSmall)) {
        AppLoadingItem(
            height = AppTheme.shapes.textTitleHeight,
            width = AppTheme.shapes.textWidthMedium
        )
        repeat(5) {
            AppLoadingItem(width = AppTheme.shapes.textWidthLarge)
        }
    }
}

@Composable
private fun LoadingUserInfo() {
    AppCard(
        modifier = Modifier.fillMaxWidth(),
        areDefaultPaddingsEnabled = true
    ) {
        AppLoadingItem(
            width = AppTheme.shapes.textWidthMedium,
            height = AppTheme.shapes.textTitleHeight
        )
        Spacer(Modifier.height(AppTheme.shapes.paddingExtraSmall))
        LoadingUserInfoLine()
        Spacer(Modifier.height(AppTheme.shapes.paddingExtraSmall))
        LoadingUserInfoLine()
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.CenterEnd
        ) {
            AppLoadingItem(height = AppTheme.shapes.textLabelHeight)
        }
    }
}

@Composable
private fun LoadingUserInfoLine() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        AppLoadingItem(
            modifier = Modifier
                .size(AppTheme.shapes.sizeMedium)
                .clip(RoundedCornerShape(100))
        )
        Spacer(Modifier.width(AppTheme.shapes.paddingSmall))
        AppLoadingItem()
    }
}

@Preview
@Composable
private fun LightLoadingPostScreenPreview() {
    LoadingPostScreenPreview()
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun DarkLoadingPostScreenPreview() {
    LoadingPostScreenPreview()
}

@Composable
private fun LoadingPostScreenPreview() {
    AppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = AppTheme.colorScheme.background
        ) {
            LoadingPostScreen()
        }
    }
}