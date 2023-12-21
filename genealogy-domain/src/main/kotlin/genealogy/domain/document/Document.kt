package genealogy.domain.document

import genealogy.domain.person.Person
import genealogy.domain.village.Village
import java.time.LocalDate
import java.util.*


/**
 * Документ
 */
interface Document {

    /** УИД документа */
    val id: UUID

    val title: String
    val documentType: DocumentTypeEnum
    val year: LocalDate
    val villages: Collection<Village>
    val persons: Collection<Person>
}