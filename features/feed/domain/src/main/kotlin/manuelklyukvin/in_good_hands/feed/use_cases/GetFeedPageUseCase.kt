package manuelklyukvin.in_good_hands.feed.use_cases

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import manuelklyukvin.in_good_hands.addresses.use_cases.GetLanguageIdUseCase
import manuelklyukvin.in_good_hands.core.operations.models.OperationResult
import manuelklyukvin.in_good_hands.core.operations.use_cases.GetOperationErrorUseCase
import manuelklyukvin.in_good_hands.feed.repositories.FeedPageRepository

class GetFeedPageUseCase(
    private val feedPageRepository: FeedPageRepository,
    private val getLanguageIdUseCase: GetLanguageIdUseCase,
    private val getOperationErrorUseCase: GetOperationErrorUseCase
) {
    suspend operator fun invoke(currentPage: Int, searchQuery: String?) = try {
        val feedPage = withContext(Dispatchers.IO) {
            feedPageRepository.getFeedPage(
                postCount = POST_COUNT,
                currentPage = currentPage,
                languageId = getLanguageIdUseCase(),
                searchQuery = searchQuery
            )
        }
        OperationResult.Success(feedPage)
    } catch (e: Exception) {
        OperationResult.Error(getOperationErrorUseCase(e))
    }

    private companion object {
        const val POST_COUNT = 10
    }
}