package genealogy.web.document

import genealogy.web.person.PersonMapper.toDto
import genealogy.domain.document.Document
import genealogy.web.village.VillageMapper.toDto

object DocumentMapper {
    fun Document.toDto(): DocumentDto =
        DocumentDto(
            id = this.id,
            title = this.title,
            documentType = this.documentType,
            year = this.year,
            villages = this.villages.toDto(),
            persons = this.persons.toDto()
        )
    fun Collection<Document>.toDto(): Collection<DocumentDto> =
        map { it.toDto() }
}