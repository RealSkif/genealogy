package genealogy.web.person

import genealogy.domain.person.Person
import genealogy.web.document.DocumentMapper.toDto
import genealogy.web.household.HouseHoldMapper.toDto
import genealogy.web.village.VillageMapper.toDto

object PersonMapper {

    fun Person.toDto(): PersonDto =
        PersonDto(
            id = this.id,
            firstName = this.firstName,
            secondName = this.secondName,
            middleName = this.middleName,
            age = 7,
            motherId = this.motherId,
            fatherId = this.fatherId,
            socialStatus = this.socialStatus,
            additionalInfo = this.additionalInfo,
            villages = this.villages?.toDto(),
            documents = this.documents?.toDto(),
            household = this.household.toDto()
        )

    fun Collection<Person>.toDto(): Collection<PersonDto> =
        map { it.toDto() }
}