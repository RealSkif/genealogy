package genealogy.web.settlement

import genealogy.domain.document.Document
import genealogy.domain.houshold.HouseHold
import genealogy.domain.person.Person
import genealogy.domain.settlement.Settlement
import genealogy.web.document.DocumentDto
import genealogy.web.household.HouseHoldDto
import genealogy.web.person.PersonDto

/** Маппер поселения в DTO */
object SettlementMapper {
    fun Settlement.toDto(): SettlementDto =
        SettlementDto(
            settlementId = this.settlementId,
            settlementName = this.settlementName,
            documents = convertDocumentsToDto(this.documents),
//            houseHolds = this.houseHolds?.let { convertHouseHoldsToDto(it, this) },
            persons = this.persons?.let { convertPersonsToDto(it) }
        )

    fun Collection<Settlement>.toDto(): Collection<SettlementDto> =
        map { it.toDto() }

    /** Методы для конвертации полей с сущностями, чтобы избежать циклической зависимостей */
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

    private fun convertHouseHoldsToDto(
        houseHolds: Collection<HouseHold>,
    ): Collection<HouseHoldDto> =
        houseHolds.map {
            HouseHoldDto(
                houseHoldId = it.houseHoldId,
                houseHoldNumber = it.houseHoldNumber,
                settlementId = it.settlementId
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
}