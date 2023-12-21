package genealogy.domain.person

import genealogy.domain.village.Village
import genealogy.domain.document.Document
import java.util.UUID

interface Person {
    val id: UUID
    val documents: Collection<Document>
    val villages: Collection<Village>
    val firstName: String
    val secondName: String
    val middleName: String
    val age: Int
    val mother: Person
    val father: Person
    val socialStatus: SocialStatusEnum
    val additionalInfo: PersonAdditionalInfoEnum
}