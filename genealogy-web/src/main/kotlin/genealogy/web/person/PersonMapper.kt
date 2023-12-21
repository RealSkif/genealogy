package genealogy.web.person

import genealogy.domain.person.Person
import genealogy.web.document.DocumentMapper.toDto
import genealogy.web.village.VillageMapper.toDto

object PersonMapper {

    fun Person.toDto(): PersonDto =
        PersonDto(
            id = this.id,
            firstName = this.firstName,
            secondName = this.secondName,
            middleName = this.middleName,
            age = this.age,
            mother = this.mother.toDto(),
            father = this.father.toDto(),
            socialStatus = this.socialStatus,
            additionalInfo = this.additionalInfo,
            villages = this.villages.toDto(),
            documents = this.documents.toDto()
        )

    fun Collection<Person>.toDto(): Collection<PersonDto> =
        map { it.toDto() }
}