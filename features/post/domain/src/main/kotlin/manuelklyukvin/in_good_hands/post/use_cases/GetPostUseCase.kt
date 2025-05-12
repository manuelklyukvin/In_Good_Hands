package manuelklyukvin.in_good_hands.post.use_cases

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import manuelklyukvin.in_good_hands.core.languages.use_cases.GetLanguageIdUseCase
import manuelklyukvin.in_good_hands.core.utils.operations.models.OperationResult
import manuelklyukvin.in_good_hands.core.utils.operations.use_cases.GetOperationErrorUseCase
import manuelklyukvin.in_good_hands.post.repositories.PostRepository

class GetPostUseCase(
    private val postRepository: PostRepository,
    private val getLanguageIdUseCase: GetLanguageIdUseCase,
    private val getOperationErrorUseCase: GetOperationErrorUseCase
) {
    suspend operator fun invoke(postId: Long) = try {
        val post = withContext(Dispatchers.IO) {
            postRepository.getPost(postId, getLanguageIdUseCase())
        }
        OperationResult.Success(post)
    } catch (e: Exception) {
        OperationResult.Error(getOperationErrorUseCase(e))
    }
}