package genealogy.domain.person

import genealogy.domain.settlement.Settlement
import genealogy.domain.document.Document
import genealogy.domain.houshold.HouseHold
import java.util.UUID

/** Человек */
interface Person {

    /** Идентификатор человека */
    val personId: UUID?

    /** Имя человека */
    val firstName: String

    /** Фамилия человека */
    val secondName: String

    /** Отчество человека */
    val middleName: String

    /** Возраст */
    val birthYear: Int

    /** Идентификатор матери человека */
    val motherId: UUID?

    /** Идентификатор отца человека */
    val fatherId: UUID?

    /** Социальный статус человека */
    val socialStatus: SocialStatusEnum

    /** Дополнительная информация */
    val additionalInfo: PersonAdditionalInfoEnum?

    /** Документы, в которых упоминается человек */
    val documents: Collection<Document>

    /** Поселения, в которых проживал человек */
    val settlements: Collection<Settlement>

    /** Дворы, в которых проживал человек */
    val houseHolds: Collection<HouseHold>

    fun compareByFullName(persons: Collection<Person>): Boolean {
        var isExist = false
        persons.forEach {
            if (it.firstName == this.firstName &&
                it.secondName == this.secondName &&
                it.middleName == this.middleName
            )
                isExist = true
        }
        return isExist
    }
}