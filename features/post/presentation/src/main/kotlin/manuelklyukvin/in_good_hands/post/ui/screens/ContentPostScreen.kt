package manuelklyukvin.in_good_hands.post.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import manuelklyukvin.in_good_hands.core.ui.components.AppCard
import manuelklyukvin.in_good_hands.core.ui.components.images.AppIcon
import manuelklyukvin.in_good_hands.core.ui.components.images.AppImage
import manuelklyukvin.in_good_hands.core.ui.components.texts.AppLineText
import manuelklyukvin.in_good_hands.core.ui.components.texts.AppText
import manuelklyukvin.in_good_hands.core.ui.theme.AppTheme
import manuelklyukvin.in_good_hands.core.ui.theme.LocalNavigationState
import manuelklyukvin.in_good_hands.core.ui.utils.noIndicationClickable
import manuelklyukvin.in_good_hands.post.R
import manuelklyukvin.in_good_hands.post.models.PresentationPet
import manuelklyukvin.in_good_hands.post.models.PresentationPost
import manuelklyukvin.in_good_hands.post.models.PresentationUser
import manuelklyukvin.in_good_hands.post.ui.utils.PostScreenParams
import manuelklyukvin.in_good_hands.post.ui.view_models.models.PostIntent
import manuelklyukvin.in_good_hands.post.ui.view_models.models.PostState
import manuelklyukvin.in_good_hands.core.R as CoreR

@Composable
internal fun ContentPostScreen(state: PostState, onIntent: (PostIntent) -> Unit) {
    val post = state.post ?: return

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = AppTheme.shapes.screenPadding)
            .clip(AppTheme.shapes.roundedCornerShape),
        verticalArrangement = Arrangement.spacedBy(AppTheme.shapes.paddingSmall)
    ) {
        item { ImagePager(post) }
        item { PostBlock(post) }
        item { UserBlock(post, onIntent) }
    }
}

@Composable
private fun ImagePager(post: PresentationPost) {
    val pagerState = rememberPagerState(pageCount = { post.imageUrls.size })

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(PostScreenParams.IMAGE_HEIGHT)
            .clip(AppTheme.shapes.roundedCornerShape)
            .background(AppTheme.colorScheme.surface),
        contentAlignment = Alignment.BottomCenter
    ) {
        HorizontalPager(pagerState) { page ->
            AppImage(
                modifier = Modifier.fillMaxSize(),
                model = post.imageUrls[page]
            )
        }
        if (pagerState.pageCount > 1) {
            ImagePagerCounter(pagerState)
        }
    }
}

@Composable
private fun ImagePagerCounter(pagerState: PagerState) {
    val currentPage = pagerState.currentPage + 1

    Box(
        modifier = Modifier
            .padding(bottom = AppTheme.shapes.paddingSmall)
            .clip(AppTheme.shapes.roundedCornerShape)
            .background(AppTheme.colorScheme.transparentContainer)
            .padding(horizontal = AppTheme.shapes.paddingSmall)
    ) {
        AppLineText(text = "$currentPage ${stringResource(R.string.image_pager_counter)} ${pagerState.pageCount}")
    }
}

@Composable
private fun PostBlock(post: PresentationPost) {
    AppCard(
        modifier = Modifier.fillMaxWidth(),
        areDefaultPaddingsEnabled = true
    ) {
        Title(post)
        Spacer(Modifier.height(AppTheme.shapes.paddingSmall))
        PetBlock(post.pet)
    }
}

@Composable
private fun Title(post: PresentationPost) {
    Column(verticalArrangement = Arrangement.spacedBy(AppTheme.shapes.paddingExtraSmall)) {
        AppText(
            text = post.title,
            style = AppTheme.typography.headline,
            color = AppTheme.colorScheme.primary
        )
        post.description?.let { AppText(text = post.description) }
    }
}

@Composable
private fun PetBlock(pet: PresentationPet) {
    Column(verticalArrangement = Arrangement.spacedBy(AppTheme.shapes.paddingExtraSmall)) {
        AppLineText(
            text = stringResource(R.string.pet_info_label),
            style = AppTheme.typography.title,
            color = AppTheme.colorScheme.primary
        )
        AppLineText(text = "${stringResource(R.string.pet_nickname_label)}: ${pet.nickname ?: stringResource(R.string.pet_default_nickname)}")
        AppLineText(text = "${stringResource(R.string.pet_type_label)}: ${stringResource(pet.typeResId)}")
        AppLineText(text = "${stringResource(R.string.pet_gender_label)}: ${stringResource(pet.genderResId)}")
        AppLineText(text = "${stringResource(R.string.pet_age_label)}: ${stringResource(pet.ageResId)}")
        AppLineText(text = "${stringResource(R.string.pet_breed_label)}: ${pet.breed ?: stringResource(R.string.pet_default_nickname)}")
    }
}

@Composable
private fun UserBlock(post: PresentationPost, onIntent: (PostIntent) -> Unit) {
    val navigationState = LocalNavigationState.current

    AppCard(
        modifier = Modifier.fillMaxWidth(),
        areDefaultPaddingsEnabled = true
    ) {
        AppLineText(
            text = stringResource(R.string.user_info_label),
            style = AppTheme.typography.title,
            color = AppTheme.colorScheme.primary
        )
        Spacer(Modifier.height(AppTheme.shapes.paddingExtraSmall))
        UserBlockLine(
            model = post.user.avatarUrl ?: painterResource(CoreR.drawable.avatar),
            text = post.user.name,
            onClick = { onIntent(PostIntent.OnUserClicked(navigationState)) }
        )
        Spacer(Modifier.height(AppTheme.shapes.paddingExtraSmall))
        UserBlockLine(
            model = painterResource(R.drawable.address),
            text = post.address,
            onClick = { onIntent(PostIntent.OnAddressClicked) }
        )
        AppLineText(
            modifier = Modifier.fillMaxWidth(),
            text = post.publicationDate,
            style = AppTheme.typography.label,
            color = AppTheme.colorScheme.outline,
            textAlign = TextAlign.End
        )
    }
}

@Composable
private fun UserBlockLine(
    model: Any,
    text: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier.noIndicationClickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (model is Painter) {
            AppIcon(
                modifier = Modifier.size(AppTheme.shapes.sizeMedium),
                model = model
            )
        } else {
            AppImage(
                modifier = Modifier
                    .size(AppTheme.shapes.sizeMedium)
                    .clip(RoundedCornerShape(100)),
                model = model,
                contentScale = ContentScale.Crop
            )
        }
        Spacer(Modifier.width(AppTheme.shapes.paddingSmall))
        AppText(text = text)
    }
}

@Preview
@Composable
private fun LightContentPostScreenPreview() {
    ContentPostScreenPreview()
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun DarkContentPostScreenPreview() {
    ContentPostScreenPreview()
}

@Composable
private fun ContentPostScreenPreview() {
    AppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = AppTheme.colorScheme.background
        ) {
            ContentPostScreen(
                state = PostState(
                    post = PresentationPost(
                        id = 0,
                        imageUrls = listOf("", ""),
                        user = PresentationUser(
                            id = 0,
                            avatarUrl = null,
                            name = "User"
                        ),
                        title = "Title",
                        description = "Description",
                        pet = PresentationPet(
                            nickname = null,
                            typeResId = R.string.pet_type_label,
                            genderResId = R.string.pet_gender_label,
                            ageResId = R.string.pet_age_label,
                            breed = null
                        ),
                        address = "Czech Republic, Prague",
                        publicationDate = "01.01.2000"
                    )
                ),
                onIntent = { }
            )
        }
    }
}