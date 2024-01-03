package genealogy.web.household

import genealogy.domain.houshold.HouseHold
import genealogy.domain.person.Person
import genealogy.web.document.DocumentDto
import genealogy.web.person.PersonDto
import genealogy.web.settlement.SettlementDto

/** Маппер двора в DTO */
object HouseHoldMapper {
    fun HouseHold.toDto(): HouseHoldDto =
        HouseHoldDto(
            houseHoldId = this.houseHoldId,
            houseHoldNumber = this.houseHoldNumber,
//            settlement = SettlementDto(
//                settlementId = this.settlement.settlementId,
//                settlementName = this.settlement.settlementName
//            ),
            settlementId = this.settlementId,
            persons = convertPersonsToDto(this.persons)
        )

    fun Collection<HouseHold>.toDto(): Collection<HouseHoldDto> =
        map { it.toDto() }

    /** Метод для конвертации полей с сущностями, чтобы избежать циклической зависимостей */
    private fun convertPersonsToDto(persons: Collection<Person>): Collection<PersonDto> =
        persons.map {
            PersonDto(
                personId = it.personId,
                firstName = it.firstName,
                secondName = it.secondName,
                middleName = it.middleName,
                birthYear = it.birthYear,
                motherId = it.motherId,
                fatherId = it.fatherId,
                socialStatus = it.socialStatus,
                additionalInfo = it.additionalInfo,
                documents = it.documents.map { document ->
                    DocumentDto(
                        title = document.title,
                        documentType = document.documentType,
                        documentDate = document.documentDate
                    )
                },
                settlements = it.settlements.map {
                    SettlementDto(
                        settlementName = it.settlementName
                    )
                },
                houseHolds = it.houseHolds.map {
                    HouseHoldDto(
                        houseHoldNumber = it.houseHoldNumber,
                        settlementId = it.settlementId
                    )
                }
            )
        }
}