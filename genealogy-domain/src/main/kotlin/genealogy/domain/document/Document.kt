package genealogy.domain.document

import genealogy.domain.person.Person
import genealogy.domain.settlement.Settlement
import java.time.LocalDate
import java.util.*


/** Документ */
interface Document {

    /** Идентификатор документа */
    val documentId: UUID?

    /** Наименование документа */
    val title: String

    /** Тип документа */
    val documentType: DocumentTypeEnum

    /** Дата документа */
    val documentDate: LocalDate

    /** Поселения, упоминаемые в документе */
    val settlements: Collection<Settlement>?

    /** Люди, упоминаемые в документе */
    val persons: Collection<Person>?
}