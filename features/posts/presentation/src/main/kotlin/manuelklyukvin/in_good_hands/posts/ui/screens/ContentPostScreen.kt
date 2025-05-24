package manuelklyukvin.in_good_hands.posts.ui.screens

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
import manuelklyukvin.in_good_hands.core.ui.components.MKUICard
import manuelklyukvin.in_good_hands.core.ui.components.images.MKUIIcon
import manuelklyukvin.in_good_hands.core.ui.components.images.MKUIImage
import manuelklyukvin.in_good_hands.core.ui.components.texts.MKUILineText
import manuelklyukvin.in_good_hands.core.ui.components.texts.MKUIText
import manuelklyukvin.in_good_hands.core.ui.theme.LocalNavigationState
import manuelklyukvin.in_good_hands.core.ui.theme.MKUITheme
import manuelklyukvin.in_good_hands.core.ui.utils.noIndicationClickable
import manuelklyukvin.in_good_hands.posts.R
import manuelklyukvin.in_good_hands.posts.models.PresentationPost
import manuelklyukvin.in_good_hands.posts.models.PresentationPostUser
import manuelklyukvin.in_good_hands.posts.ui.utils.PostScreenParams
import manuelklyukvin.in_good_hands.posts.ui.view_models.models.PostIntent
import manuelklyukvin.in_good_hands.posts.ui.view_models.models.PostState
import manuelklyukvin.in_good_hands.core.R as CoreR

@Composable
internal fun ContentPostScreen(state: PostState, onIntent: (PostIntent) -> Unit) {
    val post = state.post ?: return

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = MKUITheme.shapes.screenPadding)
            .clip(MKUITheme.shapes.roundedCornerShape),
        verticalArrangement = Arrangement.spacedBy(MKUITheme.shapes.paddingSmall)
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
            .clip(MKUITheme.shapes.roundedCornerShape)
            .background(MKUITheme.colorScheme.surface),
        contentAlignment = Alignment.BottomCenter
    ) {
        HorizontalPager(pagerState) { page ->
            MKUIImage(
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
            .padding(bottom = MKUITheme.shapes.paddingSmall)
            .clip(MKUITheme.shapes.roundedCornerShape)
            .background(MKUITheme.colorScheme.background.copy(alpha = 0.5f))
            .padding(horizontal = MKUITheme.shapes.paddingSmall)
    ) {
        MKUILineText(text = "$currentPage ${stringResource(R.string.image_pager_counter)} ${pagerState.pageCount}")
    }
}

@Composable
private fun PostBlock(post: PresentationPost) {
    MKUICard(
        modifier = Modifier.fillMaxWidth(),
        areDefaultPaddingsEnabled = true
    ) {
        Title(post)
        Spacer(Modifier.height(MKUITheme.shapes.paddingSmall))
        PetBlock(post.pet)
    }
}

@Composable
private fun Title(post: PresentationPost) {
    Column(verticalArrangement = Arrangement.spacedBy(MKUITheme.shapes.paddingExtraSmall)) {
        MKUIText(
            text = post.title,
            style = MKUITheme.typography.headline,
            color = MKUITheme.colorScheme.primary
        )
        post.description?.let { MKUIText(text = post.description) }
    }
}

@Composable
private fun PetBlock(pet: manuelklyukvin.in_good_hands.pets.models.PresentationPet) {
    Column(verticalArrangement = Arrangement.spacedBy(MKUITheme.shapes.paddingExtraSmall)) {
        MKUILineText(
            text = stringResource(R.string.pet_info_label),
            style = MKUITheme.typography.title,
            color = MKUITheme.colorScheme.primary
        )
        MKUILineText(text = "${stringResource(R.string.pet_nickname_label)}: ${pet.nickname ?: stringResource(R.string.pet_unknown_field)}")
        MKUILineText(text = "${stringResource(R.string.pet_type_label)}: ${stringResource(pet.typeResId)}")
        MKUILineText(text = "${stringResource(R.string.pet_gender_label)}: ${stringResource(pet.genderResId)}")
        MKUILineText(text = "${stringResource(R.string.pet_birth_year_label)}: ${pet.birthYear ?: stringResource(R.string.pet_unknown_field)}")
        MKUILineText(text = "${stringResource(R.string.pet_breed_label)}: ${pet.breed ?: stringResource(R.string.pet_unknown_field)}")
    }
}

@Composable
private fun UserBlock(post: PresentationPost, onIntent: (PostIntent) -> Unit) {
    val navigationState = LocalNavigationState.current

    MKUICard(
        modifier = Modifier.fillMaxWidth(),
        areDefaultPaddingsEnabled = true
    ) {
        MKUILineText(
            text = stringResource(R.string.user_info_label),
            style = MKUITheme.typography.title,
            color = MKUITheme.colorScheme.primary
        )
        Spacer(Modifier.height(MKUITheme.shapes.paddingExtraSmall))
        UserBlockLine(
            model = post.postUser.avatarUrl ?: painterResource(CoreR.drawable.avatar),
            text = post.postUser.name,
            onClick = { onIntent(PostIntent.OnUserClicked(navigationState)) }
        )
        Spacer(Modifier.height(MKUITheme.shapes.paddingExtraSmall))
        UserBlockLine(
            model = painterResource(R.drawable.address),
            text = post.addressLine,
            onClick = { onIntent(PostIntent.OnAddressClicked) }
        )
        MKUILineText(
            modifier = Modifier.fillMaxWidth(),
            text = post.publicationDate,
            style = MKUITheme.typography.label,
            color = MKUITheme.colorScheme.outline,
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
            MKUIIcon(
                modifier = Modifier.size(MKUITheme.shapes.sizeMedium),
                model = model
            )
        } else {
            MKUIImage(
                modifier = Modifier
                    .size(MKUITheme.shapes.sizeMedium)
                    .clip(RoundedCornerShape(100)),
                model = model,
                contentScale = ContentScale.Crop
            )
        }
        Spacer(Modifier.width(MKUITheme.shapes.paddingSmall))
        MKUIText(text = text)
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
    MKUITheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MKUITheme.colorScheme.background
        ) {
            ContentPostScreen(
                state = PostState(
                    post = PresentationPost(
                        id = 0,
                        imageUrls = listOf("", ""),
                        postUser = PresentationPostUser(
                            id = 0,
                            avatarUrl = null,
                            name = "User"
                        ),
                        title = "Title",
                        description = "Description",
                        pet = manuelklyukvin.in_good_hands.pets.models.PresentationPet(
                            nickname = null,
                            typeResId = R.string.pet_type_label,
                            genderResId = R.string.pet_gender_label,
                            birthYear = 2021,
                            breed = null
                        ),
                        addressLine = "Czech Republic, Prague",
                        publicationDate = "01.01.2000"
                    )
                ),
                onIntent = { }
            )
        }
    }
}