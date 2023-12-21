package genealogy.domain.houshold

import genealogy.domain.person.Person
import genealogy.domain.village.Village
import java.util.UUID

interface HouseHold {
    val id: UUID
    val houseHoldNumber: Int
    val village: Village
    val persons: Collection<Person>
}