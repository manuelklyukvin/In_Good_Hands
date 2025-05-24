package manuelklyukvin.in_good_hands.pets.mappers

import manuelklyukvin.in_good_hands.pets.models.DomainPet
import manuelklyukvin.in_good_hands.pets.models.PresentationPet

class PetMapper(
    private val petTypeMapper: PetTypeMapper,
    private val petGenderMapper: PetGenderMapper
) {
    fun toPresentation(domainPet: DomainPet) = with(domainPet) {
        PresentationPet(
            nickname = nickname,
            typeResId = petTypeMapper.toResId(typeId),
            genderResId = petGenderMapper.toResId(genderId),
            birthYear = birthYear,
            breed = breed,
        )
    }
}