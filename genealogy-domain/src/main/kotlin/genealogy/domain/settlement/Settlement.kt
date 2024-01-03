package genealogy.domain.settlement

import genealogy.domain.document.Document
import genealogy.domain.person.Person
import java.util.UUID

/** Поселение */
interface Settlement {

    /** Идентификатор поселения */
    val settlementId: UUID?

    /** Наименование поселения */
    val settlementName: String

    /** Документы, в которых упоминается поселение */
    val documents: Collection<Document>

    /** Люди, проживавшие в поселении */
    val persons: Collection<Person>?
}