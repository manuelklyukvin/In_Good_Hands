package manuelklyukvin.in_good_hands.pets.models

import com.google.gson.annotations.SerializedName

data class DataPet(
    val nickname: String?,
    @SerializedName("type_id") val typeId: Int,
    @SerializedName("gender_id") val genderId: Int,
    @SerializedName("birth_year") val birthYear: Int?,
    val breed: String?
)

fun DataPet.toDomain() = DomainPet(
    nickname = nickname,
    typeId = typeId,
    genderId = genderId,
    birthYear = birthYear,
    breed = breed
)