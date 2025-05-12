package manuelklyukvin.in_good_hands.post.models

import com.google.gson.annotations.SerializedName

data class DataPet(
    val nickname: String?,
    @SerializedName("type_id") val typeId: Int,
    @SerializedName("gender_id") val genderId: Int,
    @SerializedName("age_id") val ageId: Int,
    val breed: String?
)

fun DataPet.toDomain() = DomainPet(
    nickname = nickname,
    typeId = typeId,
    genderId = genderId,
    ageId = ageId,
    breed = breed
)