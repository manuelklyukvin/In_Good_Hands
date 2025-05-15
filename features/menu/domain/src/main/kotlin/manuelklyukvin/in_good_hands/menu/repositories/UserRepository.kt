package manuelklyukvin.in_good_hands.menu.repositories

import manuelklyukvin.in_good_hands.menu.models.DomainUser

interface UserRepository {
    suspend fun getCurrentUser(): DomainUser?
    suspend fun signOutUser()
}