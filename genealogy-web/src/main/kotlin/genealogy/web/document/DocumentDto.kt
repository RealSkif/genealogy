package genealogy.web.document

import genealogy.domain.document.Document
import genealogy.domain.document.DocumentTypeEnum
import genealogy.web.person.PersonDto
import genealogy.web.village.VillageDto
import java.time.LocalDate
import java.util.*

class DocumentDto(
    override val id: UUID,
    override val title: String,
    override val documentType: DocumentTypeEnum,
    override val year: LocalDate,
    override val villages: Collection<VillageDto>,
    override val persons: Collection<PersonDto>
) : Document {
}