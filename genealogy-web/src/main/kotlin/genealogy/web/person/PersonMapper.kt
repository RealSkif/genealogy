package genealogy.web.person

import genealogy.domain.document.Document
import genealogy.domain.houshold.HouseHold
import genealogy.domain.person.Person
import genealogy.domain.settlement.Settlement
import genealogy.web.document.DocumentDto
import genealogy.web.household.HouseHoldDto
import genealogy.web.settlement.SettlementDto

/** Маппер человека в DTO */
object PersonMapper {
    fun Person.toDto(): PersonDto =
        PersonDto(
            personId = this.personId,
            firstName = this.firstName,
            secondName = this.secondName,
            middleName = this.middleName,
            birthYear = this.birthYear,
            motherId = this.motherId,
            fatherId = this.fatherId,
            socialStatus = this.socialStatus,
            additionalInfo = this.additionalInfo,
            settlements = convertSettlementsToDto(this.settlements),
            documents = convertDocumentsToDto(this.documents),
            houseHolds = convertHouseHoldsToDto(this.houseHolds)
        )

    fun Collection<Person>.toDto(): Collection<PersonDto> =
        map { it.toDto() }

    /** Методы для конвертации полей с сущностями, чтобы избежать циклической зависимостей */
    private fun convertSettlementsToDto(settlements: Collection<Settlement>): Collection<SettlementDto> =
        settlements.map {
            SettlementDto(
                settlementId = it.settlementId,
                settlementName = it.settlementName
            )
        }

    private fun convertDocumentsToDto(documents: Collection<Document>): Collection<DocumentDto> =
        documents.map {
            DocumentDto(
                documentId = it.documentId,
                title = it.title,
                documentType = it.documentType,
                documentDate = it.documentDate,
            )
        }

    private fun convertHouseHoldsToDto(houseHolds: Collection<HouseHold>): Collection<HouseHoldDto> =
        houseHolds.map {
            HouseHoldDto(
                houseHoldId = it.houseHoldId,
                houseHoldNumber = it.houseHoldNumber,
                settlementId = it.settlementId
            )
        }
}