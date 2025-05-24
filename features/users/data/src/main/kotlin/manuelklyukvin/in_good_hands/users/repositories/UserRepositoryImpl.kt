package manuelklyukvin.in_good_hands.users.repositories

import manuelklyukvin.in_good_hands.users.data_sources.UserDataSource
import manuelklyukvin.in_good_hands.users.models.toDomain

class UserRepositoryImpl(private val userDataSource: UserDataSource) : UserRepository {
    override suspend fun getUser(userId: Long) = userDataSource.getUser(userId).toDomain()
    override suspend fun getCurrentUser() = userDataSource.getCurrentUser()?.toDomain()
}