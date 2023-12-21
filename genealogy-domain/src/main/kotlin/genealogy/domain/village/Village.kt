package genealogy.domain.village

import genealogy.domain.document.Document
import genealogy.domain.houshold.HouseHold
import genealogy.domain.person.Person
import java.util.UUID

interface Village {
val id: UUID
val name: String
val documents: Collection<Document>
val houseHolds: Collection<HouseHold>
val persons: Collection<Person>
}