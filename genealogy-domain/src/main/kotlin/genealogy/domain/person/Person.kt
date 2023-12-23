package genealogy.domain.person

import genealogy.domain.village.Village
import genealogy.domain.document.Document
import genealogy.domain.houshold.HouseHold
import java.util.UUID

interface Person {
    val id: UUID?
    val documents: Collection<Document>?
    val villages: Collection<Village>?
    val household: HouseHold
    val firstName: String?
    val secondName: String?
    val middleName: String?
    val age: Int
    val motherId: UUID?
    val fatherId: UUID?
    val socialStatus: SocialStatusEnum?
    val additionalInfo: PersonAdditionalInfoEnum?
}