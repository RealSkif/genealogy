package genealogy.data.person

import genealogy.domain.person.Person

object PersonEntityFactory {
    //
    fun Person.toEntity(): PersonEntity =
        PersonEntity(
            firstName = this.firstName,
            secondName = this.secondName,
            middleName = this.middleName,
            birthYear = this.birthYear,
            motherId = this.motherId,
            fatherId = this.fatherId,
            additionalInfo = this.additionalInfo,
            socialStatus = this.socialStatus,
            documents = mutableListOf(),
            settlements = mutableListOf(),
            houseHolds = mutableListOf()
        )

    fun Collection<Person>.toEntity(): Collection<PersonEntity> =
        this.map { it.toEntity() }
}