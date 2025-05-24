package manuelklyukvin.in_good_hands.users.data_sources

import manuelklyukvin.in_good_hands.users.models.DataUser

class UserDataSource {
    suspend fun getUser(userId: Long): DataUser {
        TODO()
    }
    suspend fun getCurrentUser(): DataUser? {
        TODO()
    }
}