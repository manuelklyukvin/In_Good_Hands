package manuelklyukvin.in_good_hands.users.repositories

import manuelklyukvin.in_good_hands.users.models.DomainUser

interface UserRepository {
    suspend fun getUser(userId: Long): DomainUser
    suspend fun getCurrentUser(): DomainUser?
}