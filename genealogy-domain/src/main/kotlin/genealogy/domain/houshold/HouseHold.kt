package genealogy.domain.houshold

import genealogy.domain.person.Person
import java.util.UUID

/** Двор */
interface HouseHold {

    /** Идентификатор двора */
    val houseHoldId: UUID?

    /** Номер двора */
    val houseHoldNumber: Int

    /** Поселение, к которому относится двор */
    val settlementId: UUID

    /** Люди, относящиеся к двору */
    val persons: Collection<Person>
}