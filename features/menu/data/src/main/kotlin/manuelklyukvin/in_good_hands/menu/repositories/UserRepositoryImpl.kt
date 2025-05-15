package manuelklyukvin.in_good_hands.menu.repositories

import manuelklyukvin.in_good_hands.menu.data_sources.UserDataSource
import manuelklyukvin.in_good_hands.menu.models.toDomain

class UserRepositoryImpl(private val userDataSource: UserDataSource) : UserRepository {
    override suspend fun getCurrentUser() = userDataSource.getCurrentUser()?.toDomain()
    override suspend fun signOutUser() = userDataSource.signOutUser()
}