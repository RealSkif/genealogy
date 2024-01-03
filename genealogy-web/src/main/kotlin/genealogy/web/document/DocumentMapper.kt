package genealogy.web.document

import genealogy.domain.document.Document
import genealogy.domain.person.Person
import genealogy.domain.settlement.Settlement
import genealogy.web.household.HouseHoldDto
import genealogy.web.person.PersonDto
import genealogy.web.settlement.SettlementDto

/** Маппер документов в DTO */
object DocumentMapper {
    fun Document.toDto(): DocumentDto =
        DocumentDto(
            documentId = this.documentId,
            title = this.title,
            documentType = this.documentType,
            documentDate = this.documentDate,
            settlements = convertSettlementsToDto(this.settlements),
            persons = convertPersonToDto(this.persons)
        )

    fun Collection<Document>.toDto(): Collection<DocumentDto> =
        map { it.toDto() }

    /** Методы для конвертации полей с сущностями, чтобы избежать циклической зависимостей */
    private fun convertSettlementsToDto(settlements: Collection<Settlement>?): Collection<SettlementDto>? =
        settlements?.map {
            SettlementDto(
                settlementId = it.settlementId,
                settlementName = it.settlementName
            )
        }

    private fun convertPersonToDto(persons: Collection<Person>?): Collection<PersonDto>? =
        persons?.map {
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