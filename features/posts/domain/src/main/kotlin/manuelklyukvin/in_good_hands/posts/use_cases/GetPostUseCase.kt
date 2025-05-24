package manuelklyukvin.in_good_hands.posts.use_cases

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import manuelklyukvin.in_good_hands.addresses.use_cases.GetLanguageIdUseCase
import manuelklyukvin.in_good_hands.core.operations.models.OperationResult
import manuelklyukvin.in_good_hands.core.operations.use_cases.GetOperationErrorUseCase
import manuelklyukvin.in_good_hands.posts.repositories.PostRepository

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