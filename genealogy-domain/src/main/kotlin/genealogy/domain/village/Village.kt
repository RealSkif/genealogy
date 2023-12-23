package genealogy.domain.village

import genealogy.domain.document.Document
import genealogy.domain.houshold.HouseHold
import genealogy.domain.person.Person
import java.util.UUID

interface Village {
val id: UUID
val name: String
val documents: Collection<genealogy.domain.document.Document>
val houseHolds: Collection<genealogy.domain.houshold.HouseHold>
val persons: Collection<genealogy.domain.person.Person>
}